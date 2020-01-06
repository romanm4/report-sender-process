package com.report.sender.delegate;

import com.report.sender.client.ws.CalculateVatWebServiceClient;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateVatDelegate implements JavaDelegate {

    @Autowired
    private CalculateVatWebServiceClient calculateVatWebServiceClient;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable(
                "calculateVatResponse",
                calculateVatWebServiceClient.calculateVat(
                        (String) execution.getVariable("productCost"),
                        (String) execution.getVariable("percentVAT")
                )
        );
    }
}
