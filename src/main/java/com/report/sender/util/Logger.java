package com.report.sender.util;

import com.report.sender.ReportSenderApplication;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Logger implements ILogger {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ReportSenderApplication.class);

    @Override
    public void log(ServiceName serviceName, LogType logType, String message) {
        switch (logType) {
            case INFO: logInfo("Start step: " + serviceName);
            break;
            case ERROR: logError("Start step: " + serviceName);
            break;
            case REQUEST: logInfo(serviceName + " request: " + message);
            break;
            case RESPONSE: logInfo(serviceName + " response: " + message);
            break;
        }
    }

    @Override
    public void log(ServiceName serviceName, LogType logType) {
        switch (logType) {
            case INFO: logInfo("Start step: " + serviceName);
                break;
            case ERROR: logError("Start step: " + serviceName);
                break;
        }
    }

    private void logInfo(String ... log) {
        LOGGER.info(convertLogToOneLineString(log));
    }

    private void logError(String ... log) {
        LOGGER.error(convertLogToOneLineString(log));
    }

    private String convertLogToOneLineString(String[] log) {
        return Arrays.toString(log).replaceAll("\\n", "");
    }

}
