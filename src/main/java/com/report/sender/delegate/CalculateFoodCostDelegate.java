package com.report.sender.delegate;

import com.report.sender.client.rest.IRestExecutor;
import com.report.sender.delegate.common.CalculateFoodCostRequest;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateFoodCostDelegate implements JavaDelegate {

    @Autowired
    private IRestExecutor restExecutor;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("calculateFoodCostResponse", restExecutor.executePostRequest(
                "http://localhost:8091/gastronomy-calculate-booster/foodcost/calculate",
                new CalculateFoodCostRequest(
                        execution.getVariable("foodCostCount").toString(),
                        execution.getVariable("foodCostRevenue").toString()
                )
            )
        );
    }
}
