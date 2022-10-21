package com.sparta.mi.logging;

import com.sparta.mi.sorters.BubbleSorter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomConfigureLogger {
    public static void configureLogger(Logger logger) {
        logger.setUseParentHandlers(false);//Turn off root logger
        logger.addHandler(CustomFileHandler.getFileHandler());
        logger.addHandler(CustomConsoleHandler.getConsoleHandler()); //Connect Logger and Handler
        logger.setLevel(Level.ALL); //set Level of Logger to ALL
    }
}
