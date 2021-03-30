package org.company.order.domain;

import java.util.List;

public class OrderLine {

    private Integer orderLineNumber;

    private String lineStatus;

    private Double lineTotalWithoutTax;

    private List<LineCharges> lineCharges;

    private List<Tax> taxes;

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public Double getLineTotalWithoutTax() {
        return lineTotalWithoutTax;
    }

    public void setLineTotalWithoutTax(Double lineTotalWithoutTax) {
        this.lineTotalWithoutTax = lineTotalWithoutTax;
    }

    public List<LineCharges> getLineCharges() {
        return lineCharges;
    }

    public void setLineCharges(List<LineCharges> lineCharges) {
        this.lineCharges = lineCharges;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }
}
