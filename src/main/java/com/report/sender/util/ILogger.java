package com.report.sender.util;

public interface ILogger {
    void log(ServiceName serviceName, LogType logType, String message);
    void log(ServiceName serviceName, LogType logType);
}
