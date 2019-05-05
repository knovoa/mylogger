package com.samples.logger.implementation;

import com.samples.logger.configuration.ConsoleConfiguration;
import com.samples.logger.helper.LoggerHelper;
import com.samples.logger.util.StringUtil;

import java.util.logging.Level;

public class ConsoleLogger implements LoggerHelper {

    public ConsoleLogger() {
        ConsoleConfiguration consoleConfiguration = new ConsoleConfiguration();
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleConfiguration.getConsoleHandler());
    }

    public void message(String message) {
        if (StringUtil.validMessage(message)) {
            logger.log(Level.INFO, message);
        }
    }

    public void warning(String message) {
        if (StringUtil.validMessage(message)) {
            logger.log(Level.WARNING, message);
        }
    }

    public void error(String message) {
        if (StringUtil.validMessage(message)) {
            logger.log(Level.SEVERE, message);
        }
    }
}
