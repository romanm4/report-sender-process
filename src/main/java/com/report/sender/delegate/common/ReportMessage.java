package com.report.sender.delegate.common;

public class ReportMessage {

    private Account account;
    private String foodCost;
    private String laborCost;
    private String vat;

    public ReportMessage() {
    }

    public ReportMessage(Account account, String foodCost, String laborCost, String vat) {
        this.account = account;
        this.foodCost = foodCost;
        this.laborCost = laborCost;
        this.vat = vat;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(String foodCost) {
        this.foodCost = foodCost;
    }

    public String getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(String laborCost) {
        this.laborCost = laborCost;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "ReportMessage{" +
                "account=" + account +
                ", foodCost='" + foodCost + '\'' +
                ", laborCost='" + laborCost + '\'' +
                ", vat='" + vat + '\'' +
                '}';
    }
}
