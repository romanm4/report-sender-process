package com.report.sender.client.ws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;

import org.apache.cxf.staxutils.StaxUtils;

@Component
public class CalculateVatWebServiceClient {

    @Value("${spring.app.test}")
    private String test;

    public void calculateVat(String productCost, String percentVat) throws MalformedURLException {

        String address = "http://localhost:8091/gastronomy-calculate-booster/ws/calculateVat";

        String request = createSoapRequest(productCost, percentVat);

        StreamSource source = new StreamSource(new StringReader(request));
        Service service = Service.create(
                new URL(address + "?wsdl"),
                new QName("http://ws.api.booster.calculate.gastronomy.com/" , "CalculateVatWebService")
        );

        Dispatch<Source> disp = service.createDispatch(
                new QName("http://ws.api.booster.calculate.gastronomy.com/" , "CalculateVatWebServicePort"),
                Source.class, Mode.PAYLOAD
        );

        Source result = disp.invoke(source);
        String resultAsString = StaxUtils.toString(result);
    }

    private String createSoapRequest(String productCost, String percentVat) {
        return "<ns1:calculateVat xmlns:ns1='http://ws.api.booster.calculate.gastronomy.com/'>\n" +
                "  <productCost>" + productCost + "</productCost>\n" +
                "  <percentVAT>" + percentVat + "</percentVAT>\n" +
                "</ns1:calculateVat>";
    }

}
