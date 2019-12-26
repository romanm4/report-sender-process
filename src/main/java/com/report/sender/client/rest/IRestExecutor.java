package com.report.sender.client.rest;

import org.springframework.stereotype.Component;

public interface IRestExecutor {

    String executePostRequest(String url, Object request);

    String executeGetRequest(String url);

}
