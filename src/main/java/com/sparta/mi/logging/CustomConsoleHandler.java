package com.sparta.mi.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class CustomConsoleHandler {
    public static ConsoleHandler getConsoleHandler() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL); //set Level of handler to ALL to print all levels
        consoleHandler.setFilter(new CustomFilter()); //Filter console handler for what you want to see
        return consoleHandler;
    }
}
