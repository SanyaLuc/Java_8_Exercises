package edu.san.luc.java8.chapter3;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by sanya on 13.12.15.
 */
public class LogIf {
    private Logger log = Logger.getLogger(getClass().getName());
    public static void main(String[] args) throws IOException {
        InputStream in = LogIf.class.getResourceAsStream("/logging.properties");
        LogManager.getLogManager().readConfiguration(in);

        //System.setProperty("java.util.logging.config.file", "");
    }


}
