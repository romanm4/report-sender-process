package com.report.sender.validate;

import org.springframework.stereotype.Component;


@Component
public class XmlValidator implements IXmlValidator {

    @Override
    public boolean isXmlValid(String xml) {
        if (xml.matches("(?s).*(<(\\w+)[^>]*>.*</\\2>|<(\\w+)[^>]*/>).*")) return true;
        else return false;
    }
}
