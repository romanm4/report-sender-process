package com.report.sender.delegate;

import com.report.sender.facade.AccountDataFacade;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountDataDelegate implements JavaDelegate {

    @Autowired
    private AccountDataFacade accountDataFacade;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable(
                "accountDataResponse",
                accountDataFacade.executeHttpGetAccountData((Long) execution.getVariable("accountId"))
        );
    }


}
