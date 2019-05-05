package com.samples.logger.util;

public class StringUtil {

    public static boolean validMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new RuntimeException("Invalid message");
        }
        return true;
    }
} 
