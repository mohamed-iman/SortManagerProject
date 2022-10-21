package com.sparta.mi.logging;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
//This class formats the logger however I want it to look
    @Override
    public String format(LogRecord record) {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE)
                + " " + record.getSourceMethodName()
                + " " + record.getLevel()
                + " " + record.getMessage()
                + " \n";
    }
}
