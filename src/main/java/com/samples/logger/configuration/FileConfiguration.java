package com.samples.logger.configuration;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class FileConfiguration {

    private Properties properties;

    public FileConfiguration(Properties properties) {
        this.properties = properties;
    }

    public FileHandler getFileHandler() {
        try {
            File logFile = new File(properties.getProperty("logger.file.path"));
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            FileHandler fileHandler = new FileHandler(properties.getProperty("logger.file.path"));
            fileHandler.setFormatter(new SimpleFormatter());
            return fileHandler;
        } catch (IOException e) {
            throw new RuntimeException("Error cannot get fileHandler", e);
        }
    }
}
