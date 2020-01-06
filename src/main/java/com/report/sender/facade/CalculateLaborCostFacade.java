package com.report.sender.facade;

import com.report.sender.client.rest.IRestExecutor;
import com.report.sender.delegate.common.CalculateLaborCostRequest;
import com.report.sender.util.ILogger;
import com.report.sender.util.LogType;
import com.report.sender.util.ServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalculateLaborCostFacade {

    @Autowired
    private IRestExecutor restExecutor;

    @Autowired
    private ILogger logger;

    @Value("${spring.app.url.rest.calculateLaborCost}")
    private String url;

    public String executePostCalculateLaborCost(String laborCostCount, String laborCostRevenue) {
        logger.log(ServiceName.CALCULATE_LABOR_DELEGATE, LogType.INFO);
        CalculateLaborCostRequest request = prepareCalculateLaborCostRequest(laborCostCount, laborCostRevenue);
        logger.log(ServiceName.CALCULATE_LABOR_DELEGATE, LogType.REQUEST, request.toString());
        String response = restExecutor.executePostRequest(url, request);
        logger.log(ServiceName.CALCULATE_LABOR_DELEGATE, LogType.RESPONSE, response);
        return response;
    }

    private CalculateLaborCostRequest prepareCalculateLaborCostRequest(String laborCostCount, String laborCostRevenue) {
        return new CalculateLaborCostRequest(laborCostCount, laborCostRevenue);
    }

}
