package com.report.sender.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class RestExecutor implements IRestExecutor {

    @Autowired
    private RestTemplate restTemplate;

    public String executePostRequest(String url, Object request) {
        HttpHeaders headers = getHttpHeaders();
        HttpEntity<Object> entity = new HttpEntity<Object>(request, headers);
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
    }

    @Override
    public String executeGetRequest(String url) {
        HttpHeaders headers = getHttpHeaders();
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

}
