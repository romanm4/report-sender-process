package com.report.sender.delegate;

import com.report.sender.client.rest.IRestExecutor;
import com.report.sender.delegate.common.CalculateLaborCostRequest;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateLaborCostDelegate implements JavaDelegate {

    @Autowired
    private IRestExecutor restExecutor;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("calculateLaborCostResponse", restExecutor.executePostRequest(
                "http://localhost:8091/gastronomy-calculate-booster/laborcost/calculate",
                new CalculateLaborCostRequest(
                        execution.getVariable("laborCostCount").toString(),
                        execution.getVariable("laborCostRevenue").toString()
                )
            )
        );
    }
}
