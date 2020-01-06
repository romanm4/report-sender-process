package com.report.sender.facade;

import com.report.sender.client.rest.IRestExecutor;
import com.report.sender.util.ILogger;
import com.report.sender.util.LogType;
import com.report.sender.util.ServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccountDataFacade {

    @Autowired
    private IRestExecutor restExecutor;

    @Autowired
    private ILogger logger;

    @Value("${spring.app.url.rest.accountData}")
    private String url;

    public String executeHttpGetAccountData(Long accountId) {
        logger.log(ServiceName.ACCOUNT_DATA_DELEGATE, LogType.INFO);
        logger.log(ServiceName.ACCOUNT_DATA_DELEGATE, LogType.REQUEST, "HTTP GET " + url + accountId);
        String response = restExecutor.executeGetRequest(url + accountId);
        logger.log(ServiceName.ACCOUNT_DATA_DELEGATE, LogType.RESPONSE, response);
        return response;
    }

}
