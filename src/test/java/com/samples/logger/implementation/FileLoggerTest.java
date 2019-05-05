package com.samples.logger.implementation;

import com.samples.logger.contants.LoggerType;
import com.samples.logger.factory.LoggerFactory;
import com.samples.logger.helper.LoggerHelper;
import org.junit.Assert;
import org.junit.Test;

public class FileLoggerTest {

    @Test
    public void shouldLogInFileWithDifferentMessageTypes() {
        LoggerHelper logger = LoggerFactory.getLogger(LoggerType.FILE);
        logger.message("Everything is good!");
        logger.warning("Houston we have a warning!");
        logger.error("A fatal error occurred!");
        Assert.assertTrue(logger instanceof FileLogger);
    }
}
