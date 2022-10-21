package com.sparta.mi.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
//Create and configure custom FileHandler
public class CustomFileHandler {
    public static FileHandler getFileHandler() {
        try {
            FileHandler fileHandler = new FileHandler("src/main/java/com/sparta/mi/myLogger", true);//
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new CustomFormatter());
            return fileHandler;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}