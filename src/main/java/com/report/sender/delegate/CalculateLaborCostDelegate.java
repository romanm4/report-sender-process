package com.report.sender.delegate;

import com.report.sender.facade.CalculateLaborCostFacade;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateLaborCostDelegate implements JavaDelegate {

    @Autowired
    private CalculateLaborCostFacade calculateLaborCostFacade;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable(
                "calculateLaborCostResponse",
                    calculateLaborCostFacade.executePostCalculateLaborCost(
                            (String) execution.getVariable("laborCostCount"),
                            (String) execution.getVariable("laborCostRevenue")
                    )
        );
    }
}
