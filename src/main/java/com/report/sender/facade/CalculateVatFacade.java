package com.report.sender.facade;

import com.report.sender.client.ws.CalculateVatWebServiceClient;
import com.report.sender.util.ILogger;
import com.report.sender.util.LogType;
import com.report.sender.util.ServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
public class CalculateVatFacade {

    @Autowired
    private CalculateVatWebServiceClient calculateVatWebServiceClient;

    @Autowired
    private ILogger logger;

    public String executeCalculateVatWebService(String productCost, String percentVAT) {
        try {
            logger.log(ServiceName.CALCULATE_VAT_DELEGATE, LogType.INFO);
            String response = calculateVatWebServiceClient.calculateVat(productCost, percentVAT);
            logger.log(ServiceName.CALCULATE_VAT_DELEGATE, LogType.RESPONSE, response);
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }

}
