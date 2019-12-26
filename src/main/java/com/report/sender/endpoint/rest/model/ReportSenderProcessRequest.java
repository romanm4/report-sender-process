package com.report.sender.endpoint.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportSenderProcessRequest {

    @JsonProperty("foodCostCount")
    private String foodCostCount;

    @JsonProperty("foodCostRevenue")
    private String foodCostRevenue;

    @JsonProperty("laborCostCount")
    private String laborCostCount;

    @JsonProperty("laborCostRevenue")
    private String laborCostRevenue;

    @JsonProperty("productCost")
    private String productCost;

    @JsonProperty("percentVAT")
    private String percentVAT;

    public ReportSenderProcessRequest() {
    }

    public ReportSenderProcessRequest(String foodCostCount, String foodCostRevenue, String laborCostCount, String laborCostRevenue, String productCost, String percentVAT) {
        this.foodCostCount = foodCostCount;
        this.foodCostRevenue = foodCostRevenue;
        this.laborCostCount = laborCostCount;
        this.laborCostRevenue = laborCostRevenue;
        this.productCost = productCost;
        this.percentVAT = percentVAT;
    }

    public String getFoodCostCount() {
        return foodCostCount;
    }

    public void setFoodCostCount(String foodCostCount) {
        this.foodCostCount = foodCostCount;
    }

    public String getFoodCostRevenue() {
        return foodCostRevenue;
    }

    public void setFoodCostRevenue(String foodCostRevenue) {
        this.foodCostRevenue = foodCostRevenue;
    }

    public String getLaborCostCount() {
        return laborCostCount;
    }

    public void setLaborCostCount(String laborCostCount) {
        this.laborCostCount = laborCostCount;
    }

    public String getLaborCostRevenue() {
        return laborCostRevenue;
    }

    public void setLaborCostRevenue(String laborCostRevenue) {
        this.laborCostRevenue = laborCostRevenue;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }

    public String getPercentVAT() {
        return percentVAT;
    }

    public void setPercentVAT(String percentVAT) {
        this.percentVAT = percentVAT;
    }

    @Override
    public String toString() {
        return "ReportSenderProcessRequest{" +
                "foodCostCount='" + foodCostCount + '\'' +
                ", foodCostRevenue='" + foodCostRevenue + '\'' +
                ", laborCostCount='" + laborCostCount + '\'' +
                ", laborCostRevenue='" + laborCostRevenue + '\'' +
                ", productCost='" + productCost + '\'' +
                ", percentVAT='" + percentVAT + '\'' +
                '}';
    }
}
