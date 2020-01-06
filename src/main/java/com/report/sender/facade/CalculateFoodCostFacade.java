package com.report.sender.facade;

import com.report.sender.client.rest.IRestExecutor;
import com.report.sender.delegate.common.CalculateFoodCostRequest;
import com.report.sender.util.ILogger;
import com.report.sender.util.LogType;
import com.report.sender.util.ServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalculateFoodCostFacade {

    @Autowired
    private IRestExecutor restExecutor;

    @Autowired
    private ILogger logger;

    @Value("${spring.app.url.rest.calculateFoodCost}")
    private String url;

    public String executePostCalculateFoodCost(String foodCostCount, String foodCostRevenue) {
        logger.log(ServiceName.CALCULATE_FOOD_DELEGATE, LogType.INFO);
        CalculateFoodCostRequest request = prepareCalculateFoodCostRequest(foodCostCount, foodCostRevenue);
        logger.log(ServiceName.CALCULATE_FOOD_DELEGATE, LogType.REQUEST, request.toString());
        String response = restExecutor.executePostRequest(url, request);
        logger.log(ServiceName.CALCULATE_FOOD_DELEGATE, LogType.RESPONSE, response);
        return response;
    }

    private CalculateFoodCostRequest prepareCalculateFoodCostRequest(String foodCostCount, String foodCostRevenue) {
        return new CalculateFoodCostRequest(foodCostCount, foodCostRevenue);
    }
}
