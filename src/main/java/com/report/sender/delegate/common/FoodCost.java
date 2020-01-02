package com.report.sender.delegate.common;

public class FoodCost {

    private String foodCost;

    public FoodCost() {
    }

    public FoodCost(String foodCost) {
        this.foodCost = foodCost;
    }

    public String getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(String foodCost) {
        this.foodCost = foodCost;
    }

    @Override
    public String toString() {
        return "FoodCost{" +
                "foodCost='" + foodCost + '\'' +
                '}';
    }
}
