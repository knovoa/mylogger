package com.samples.logger.implementation;

import com.samples.logger.contants.LoggerType;
import com.samples.logger.factory.LoggerFactory;
import com.samples.logger.helper.LoggerHelper;
import org.junit.Assert;
import org.junit.Test;

public class DatabaseLoggerTest {

    @Test
    public void shouldLogInDatabaseWithDifferentMessageTypes() {
        LoggerHelper logger = LoggerFactory.getLogger(LoggerType.DATABASE);
        logger.message("Logging message on db!");
        logger.warning("Logging a warning on db!");
        logger.error("logging a error on db!");
        Assert.assertTrue(logger instanceof DatabaseLogger);
    }
}
