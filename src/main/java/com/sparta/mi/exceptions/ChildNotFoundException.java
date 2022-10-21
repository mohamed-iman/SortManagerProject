package com.sparta.mi.exceptions;

public class ChildNotFoundException extends Exception{
    @Override
    public String getMessage() {
        return "Unable to find element in binary tree";
    }
}
