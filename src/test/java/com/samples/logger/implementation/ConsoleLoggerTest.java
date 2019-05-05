package com.samples.logger.implementation;

import com.samples.logger.contants.LoggerType;
import com.samples.logger.factory.LoggerFactory;
import com.samples.logger.helper.LoggerHelper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConsoleLoggerTest {

    private LoggerHelper logger;

    @Before
    public void setUp() {
        logger = LoggerFactory.getLogger(LoggerType.CONSOLE);
    }

    @Test
    public void shouldLogInConsoleWithDifferentMessageTypes() {
        logger.message("Everything is good!");
        logger.warning("Houston we have a warning!");
        logger.error("A fatal error occurred!");
        Assert.assertTrue(logger instanceof ConsoleLogger);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRunTimeExceptionWhenMessageIsNull() {
        logger.message(null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRunTimeExceptionWhenMessageIsEmpty() {
        logger.message("");
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRunTimeExceptionWhenMessageHaveBlankSpaces() {
        logger.message("   ");
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRunTimeExceptionWhenLoggerTypeNotFound() {
        LoggerHelper logger = LoggerFactory.getLogger("Not Implemented type");
        logger.message("Interesting... Exception Unit Testing");
    }
}
