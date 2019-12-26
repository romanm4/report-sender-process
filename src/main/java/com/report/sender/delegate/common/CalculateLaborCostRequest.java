package com.report.sender.delegate.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class CalculateLaborCostRequest {

    @JsonProperty("staff")
    @NotNull
    @NotBlank
    @DecimalMin("0.0")
    private String staffCosts;

    @JsonProperty("revenue")
    @NotNull
    @NotBlank
    @DecimalMin("0.0")
    private String amountRevenue;

    public CalculateLaborCostRequest() {
    }

    public CalculateLaborCostRequest(String staffCosts, String amountRevenue) {
        this.staffCosts = staffCosts;
        this.amountRevenue = amountRevenue;
    }

    public String getStaffCosts() {
        return staffCosts;
    }

    public void setStaffCosts(String staffCosts) {
        this.staffCosts = staffCosts;
    }

    public String getAmountRevenue() {
        return amountRevenue;
    }

    public void setAmountRevenue(String amountRevenue) {
        this.amountRevenue = amountRevenue;
    }

    @Override
    public String toString() {
        return "CalculateLaborCostRequest{" +
                "staffCosts='" + staffCosts + '\'' +
                ", amountRevenue='" + amountRevenue + '\'' +
                '}';
    }
}
