package com.sparta.mi.exceptions;

public class SorterLoaderException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Invalid sort method";
    }
}
