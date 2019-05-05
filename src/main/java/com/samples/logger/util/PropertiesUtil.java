package com.samples.logger.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    public Properties getLoggerProperties() {
        Properties properties = new Properties();

        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("logger.properties");
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Logger Properties cannot be found");
        }
        return properties;
    }
}
