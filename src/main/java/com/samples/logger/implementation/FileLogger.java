package com.samples.logger.implementation;

import com.samples.logger.configuration.FileConfiguration;
import com.samples.logger.helper.LoggerHelper;
import com.samples.logger.util.PropertiesUtil;
import com.samples.logger.util.StringUtil;

import java.util.Properties;
import java.util.logging.Level;

public class FileLogger implements LoggerHelper {

    public FileLogger(PropertiesUtil propertiesUtil) {
        Properties properties = propertiesUtil.getLoggerProperties();
        FileConfiguration fileConfiguration = new FileConfiguration(properties);
        logger.setUseParentHandlers(false);
        logger.addHandler(fileConfiguration.getFileHandler());
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
