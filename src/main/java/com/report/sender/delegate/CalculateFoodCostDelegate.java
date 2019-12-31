package com.report.sender.delegate;

import com.report.sender.client.rest.IRestExecutor;
import com.report.sender.delegate.common.CalculateFoodCostRequest;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CalculateFoodCostDelegate implements JavaDelegate {

    @Autowired
    private IRestExecutor restExecutor;

    @Value("${spring.app.url.rest.calculateFoodCost}")
    private String url;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("calculateFoodCostResponse", restExecutor.executePostRequest(
                url,
                new CalculateFoodCostRequest(
                        execution.getVariable("foodCostCount").toString(),
                        execution.getVariable("foodCostRevenue").toString()
                )
            )
        );
    }
}
