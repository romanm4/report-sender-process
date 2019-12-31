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

    @Value("${spring.app.url.soap.calculateVat}")
    private String url;

    @Value("${spring.app.url.soap.namespaceURI}")
    private String namespaceURI;

    public String calculateVat(String productCost, String percentVat) throws MalformedURLException {

        String request = createSoapRequest(productCost, percentVat);

        StreamSource source = new StreamSource(new StringReader(request));
        Service service = Service.create(
                new URL(url),
                new QName(namespaceURI , "CalculateVatWebService")
        );

        Dispatch<Source> dispatch = service.createDispatch(
                new QName(namespaceURI , "CalculateVatWebServicePort"),
                Source.class, Mode.PAYLOAD
        );

        return StaxUtils.toString(dispatch.invoke(source));
    }

    private String createSoapRequest(String productCost, String percentVat) {
        return "<ns1:calculateVat xmlns:ns1='" + namespaceURI + "'>\n" +
                "  <productCost>" + productCost + "</productCost>\n" +
                "  <percentVAT>" + percentVat + "</percentVAT>\n" +
                "</ns1:calculateVat>";
    }

}
