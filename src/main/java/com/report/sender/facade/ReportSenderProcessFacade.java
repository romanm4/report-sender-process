package com.report.sender.facade;

import com.report.sender.endpoint.rest.model.ReportSenderProcessRequest;
import com.report.sender.util.ILogger;
import com.report.sender.util.LogType;
import com.report.sender.util.ServiceName;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ReportSenderProcessFacade {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ILogger logger;

    public void startProcess(Long accountId, ReportSenderProcessRequest request) {
        logger.log(ServiceName.START_SEND_REPORT_PROCESS, LogType.INFO);
        Map<String, Object> variables = prepareContextVariables(accountId, request);
        runtimeService.startProcessInstanceByKey("java-delegate-report-sender-process", variables);
    }

    private Map<String, Object> prepareContextVariables(Long accountId, ReportSenderProcessRequest request) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("accountId", accountId);
        variables.put("foodCostCount", request.getFoodCostCount());
        variables.put("foodCostRevenue", request.getFoodCostRevenue());
        variables.put("laborCostCount", request.getLaborCostCount());
        variables.put("laborCostRevenue", request.getLaborCostRevenue());
        variables.put("productCost", request.getProductCost());
        variables.put("percentVAT", request.getPercentVAT());
        return variables;
    }

}
