package com.samples.logger.helper;

import java.util.logging.Logger;

public interface LoggerHelper {

    Logger logger = Logger.getLogger("LoggerHelper");

    void message(String message);
    void warning(String message);
    void error(String message);
}
