package org.company.order.service.impl;

import org.company.order.domain.LineCharges;
import org.company.order.domain.Order;
import org.company.order.domain.OrderLine;
import org.company.order.domain.Tax;
import org.company.order.domain.enumeration.LineStatusEnum;
import org.company.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order getTotalOrder(Order order) {
        double totalOrder = 0d;

        List<OrderLine> orderLines = order.getOrderLines();

        if (orderLines == null) return order;

        for (OrderLine orderLine : orderLines) {

            if (orderLine.getLineStatus() == null) continue;

            // calculate total charges for current orderLine
            double sumCharges = 0;
            if (orderLine.getLineCharges() != null)
                sumCharges = orderLine.getLineCharges().stream().mapToDouble(LineCharges::getChargeAmount).sum();

            // calculate total taxes for current orderLine
            double sumTaxes = 0;
            if (orderLine.getTaxes() != null)
                sumTaxes = orderLine.getTaxes().stream().mapToDouble(Tax::getTaxAmount).sum();

            //Total line
            double lineTotal = 0;
            if (orderLine.getLineTotalWithoutTax() != null)
                lineTotal = orderLine.getLineTotalWithoutTax() + sumCharges + sumTaxes;

            //add to total order if the status is created and subtract if it's return or canceled

            if (orderLine.getLineStatus().equals(LineStatusEnum.CREATED.name())) {
                totalOrder += lineTotal;
            } else if (orderLine.getLineStatus().equals(LineStatusEnum.CANCELLED.name()) || orderLine.getLineStatus().equals(LineStatusEnum.RETURNED.name())) {
                totalOrder -= lineTotal;
            }
        }
        order.setOrderTotal(totalOrder);
        return order;
    }
}
