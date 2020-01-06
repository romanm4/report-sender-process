package com.report.sender.delegate;

import com.report.sender.facade.CalculateFoodCostFacade;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class CalculateFoodCostDelegate implements JavaDelegate {

    @Autowired
    private CalculateFoodCostFacade calculateFoodCostFacade;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable(
                "calculateFoodCostResponse",
                calculateFoodCostFacade.executePostCalculateFoodCost(
                        (String) execution.getVariable("foodCostCount"),
                        (String) execution.getVariable("foodCostRevenue")
                )
        );
    }
}
