package com.report.sender.delegate;

import com.report.sender.facade.SendReportMessageFacade;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReportMessageDelegate implements JavaDelegate {

    @Autowired
    private SendReportMessageFacade sendReportMessageFacade;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        sendReportMessageFacade.sendReportMessage(execution.getVariables());
    }
}
