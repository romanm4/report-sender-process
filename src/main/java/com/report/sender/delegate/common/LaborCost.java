package com.report.sender.delegate.common;

public class LaborCost {

    private String laborCost;

    public LaborCost() {
    }

    public LaborCost(String laborCost) {
        this.laborCost = laborCost;
    }

    public String getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(String laborCost) {
        this.laborCost = laborCost;
    }

    @Override
    public String toString() {
        return "LaborCost{" +
                "laborCost='" + laborCost + '\'' +
                '}';
    }
}
