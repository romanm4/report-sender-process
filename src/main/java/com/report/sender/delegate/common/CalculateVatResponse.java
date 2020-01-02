package com.report.sender.delegate.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "calculateVatResponse", namespace = "http://ws.api.booster.calculate.gastronomy.com/")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CalculateVatResponse {

    private String vat;

    public CalculateVatResponse() {
    }

    public CalculateVatResponse(String vat) {
        this.vat = vat;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "CalculateVatResponse{" +
                "vat='" + vat + '\'' +
                '}';
    }
}
