package edu.san.luc.java8.chapter3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by sanya on 13.12.15.
 */
public class LogIf {
    private Logger log = Logger.getLogger(getClass().getName());
    public static void main(String[] args) throws IOException, URISyntaxException {
//        InputStream in = LogIf.class.getResourceAsStream("/logging.properties");
//        LogManager.getLogManager().readConfiguration(in);
//
        File file = new File(ClassLoader.getSystemResource("logging.properties").toURI());
        System.setProperty("java.util.logging.config.file", file.getAbsolutePath());
        LogManager.getLogManager().readConfiguration();

        LogIf logIf = new LogIf();
        logIf.log.severe("severe");
        logIf.log.warning("warning");
        logIf.log.info("info");
        logIf.log.config("config");
        logIf.log.fine("fine");
        logIf.log.finer("finer");
        logIf.log.finest("finest");
        logIf.log.log(Level.ALL, "log ALL");
    }


}
