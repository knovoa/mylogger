package com.samples.logger.configuration;

import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;

public class ConsoleConfiguration {

    public ConsoleHandler getConsoleHandler( ) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        return consoleHandler;
    }
}
