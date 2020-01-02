package com.report.sender.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.report.sender.delegate.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;


@Component
public class SendReportMessageFacade {

    @Autowired
    private ObjectMapper objectMapper;

    public void sendReportMessage(Map<String, Object> variables) {
        String message = convertObjectToJsonString(prepareReportMessage(variables));
    }

    private ReportMessage prepareReportMessage(Map<String, Object> variables) {
        try {
            return new ReportMessage(
                    objectMapper.readValue(
                            getVariableByKey(variables, "accountDataResponse"),
                            Account.class
                    ),
                    objectMapper.readValue(
                            getVariableByKey(variables, "calculateFoodCostResponse"),
                            FoodCost.class
                    ).getFoodCost(),
                    objectMapper.readValue(
                            getVariableByKey(variables, "calculateLaborCostResponse"),
                            LaborCost.class
                    ).getLaborCost(),
                    convertXmlToObject(
                            getVariableByKey(variables, "calculateVatResponse")
                    ).getVat()
            );
        } catch (IOException e) {
            e.printStackTrace();
            return new ReportMessage();
        }
    }

    private CalculateVatResponse convertXmlToObject(String xml) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CalculateVatResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return  (CalculateVatResponse) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String convertObjectToJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String getVariableByKey(Map<String, Object> variables, String key) {
        return (String) variables.get(key);
    }

}
