package com.report.sender.client.ws;

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
    public void send() throws MalformedURLException {
        String address = "http://localhost:8091/gastronomy-calculate-booster/ws/calculateVat";
        String request = "<ws:calculateVat>\n" +
                "         <productCost>22</productCost>\n" +
                "         <percentVAT>6</percentVAT>\n" +
                "      </ws:calculateVat>\n";

        StreamSource source = new StreamSource(new StringReader(request));
        Service service = Service.create(new URL(address + "?wsdl"),
                new QName("http://ws.api.booster.calculate.gastronomy.com/" , "HelloService"));
        Dispatch<Source> disp = service.createDispatch(new QName("http://ws.api.booster.calculate.gastronomy.com/" , "HelloPort"),
                Source.class, Mode.PAYLOAD);

        Source result = disp.invoke(source);
        String resultAsString = StaxUtils.toString(result);
        System.out.println(resultAsString);
    }
}
