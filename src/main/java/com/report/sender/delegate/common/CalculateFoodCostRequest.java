package com.report.sender.delegate.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class CalculateFoodCostRequest {

    @JsonProperty("cost")
    private String costProduct;

    @JsonProperty("revenue")
    private String amountRevenue;

    public CalculateFoodCostRequest(String costProduct, String amountRevenue) {
        this.costProduct = costProduct;
        this.amountRevenue = amountRevenue;
    }

    public String getCostProduct() {
        return costProduct;
    }

    public void setCostProduct(String costProduct) {
        this.costProduct = costProduct;
    }

    public String getAmountRevenue() {
        return amountRevenue;
    }

    public void setAmountRevenue(String amountRevenue) {
        this.amountRevenue = amountRevenue;
    }

    @Override
    public String toString() {
        return "CalculateFoodCostRequest{" +
                "costProduct=" + costProduct +
                ", amountRevenue=" + amountRevenue +
                '}';
    }
}
