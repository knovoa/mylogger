package com.samples.logger.implementation;

import com.samples.logger.configuration.DatabaseConfiguration;
import com.samples.logger.contants.MessageType;
import com.samples.logger.helper.LoggerHelper;
import com.samples.logger.util.PropertiesUtil;

import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

public class DatabaseLogger implements LoggerHelper {

    private DatabaseConfiguration databaseConfiguration;

    public DatabaseLogger(PropertiesUtil propertiesUtil) {
        Properties properties = propertiesUtil.getLoggerProperties();
        databaseConfiguration = new DatabaseConfiguration(properties);
        databaseConfiguration.createTableIfNotExists();
    }

    public void message(String message) {
        String messageLog = "Message "
                + DateFormat.getDateInstance(DateFormat.LONG).format(new Date())
                + " " + message;
        databaseConfiguration.insertMessage(messageLog, MessageType.MESSAGE);
    }

    public void warning(String message) {
        String warningLog = "Warning "
                + DateFormat.getDateInstance(DateFormat.LONG).format(new Date())
                + " " + message;
        databaseConfiguration.insertMessage(warningLog, MessageType.WARNING);
    }

    public void error(String message) {
        String errorLog = "Error "
                + DateFormat.getDateInstance(DateFormat.LONG).format(new Date())
                + " " + message;
        databaseConfiguration.insertMessage(errorLog, MessageType.ERROR);
    }
}
