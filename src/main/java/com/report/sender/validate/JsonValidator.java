package com.report.sender.validate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonValidator implements IJsonValidator {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean isJsonValid(String json) {
        try {
            objectMapper.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
