package com.samples.logger.factory;

import com.samples.logger.contants.LoggerType;
import com.samples.logger.helper.LoggerHelper;
import com.samples.logger.implementation.ConsoleLogger;
import com.samples.logger.implementation.DatabaseLogger;
import com.samples.logger.implementation.FileLogger;
import com.samples.logger.util.PropertiesUtil;

public class LoggerFactory {

    public static LoggerHelper getLogger(String type) {
        if (LoggerType.CONSOLE.equalsIgnoreCase(type)) {
            return new ConsoleLogger();
        } else if (LoggerType.FILE.equalsIgnoreCase(type)) {
            return new FileLogger(new PropertiesUtil());
        } else if (LoggerType.DATABASE.equalsIgnoreCase(type)) {
            return new DatabaseLogger(new PropertiesUtil());
        } else {
            throw new RuntimeException("LoggerType implementation not found");
        }
    }
}
