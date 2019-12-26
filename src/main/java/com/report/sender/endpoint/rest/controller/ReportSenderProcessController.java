package com.report.sender.endpoint.rest.controller;

import com.report.sender.endpoint.rest.model.ReportSenderProcessRequest;
import com.report.sender.facade.ReportSenderProcessFacade;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account/{accountId}")
public class ReportSenderProcessController {

    @Autowired
    private ReportSenderProcessFacade reportSenderProcessFacade;

    @PostMapping(value = "/report", consumes = "application/json", produces = "application/json")
    public void sendNewReport(@PathVariable Long accountId, @RequestBody ReportSenderProcessRequest request) {
        reportSenderProcessFacade.startProcess(accountId, request);
    }
}
