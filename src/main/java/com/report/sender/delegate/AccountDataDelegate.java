package com.report.sender.delegate;

import com.report.sender.client.rest.IRestExecutor;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class AccountDataDelegate implements JavaDelegate {

    @Autowired
    private IRestExecutor restExecutor;

    @Value("${spring.app.url.rest.accountData}")
    private String url;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable(
                "accountDataResponse",
                restExecutor.executeGetRequest(url + execution.getVariable("accountId"))
        );
    }


}
