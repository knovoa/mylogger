package com.samples.logger.util;

import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class PropertiesUtilTest {

    private PropertiesUtil propertiesUtil;

    @Before
    public void setUp() {
        propertiesUtil = new PropertiesUtil();
    }

    @Test
    public void shouldGetPropertiesFromFile() {
        Properties loggerProperties = propertiesUtil.getLoggerProperties();
        assertNotNull(loggerProperties);
        assertEquals("./logs/file.log", loggerProperties.getProperty("logger.file.path"));
        assertEquals("root", loggerProperties.getProperty("logger.db.username"));
        assertEquals("root", loggerProperties.getProperty("logger.db.password"));
        assertEquals("org.h2.Driver", loggerProperties.getProperty("logger.db.jdbc.driver"));
        assertEquals("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", loggerProperties.getProperty("logger.db.url"));
    }
}
