package com.sparta.mi.logging;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CustomFilter implements Filter {
// Filters for desired output on logger
    @Override
    public boolean isLoggable(LogRecord record) {
        return record.getMessage().contains("nothing");
    }
}
