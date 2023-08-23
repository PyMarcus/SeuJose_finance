package util;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type FLogger (SINGLETON TO BEST PERFORMANCE).
 *
 * This class create log in everywhere from system
 * to detail the what's happening.
 */
public class FLogger {
    private static final Logger logger = Logger.getLogger(FLogger.class.getName());
    private final static String LOGFILE = "finances" + DateParse.parseDatetimeToStringLog(
            DateParse.generateCurrentLocalTime()) + ".log";

    static{
        logger.setLevel(Level.INFO);
        try {
            FileHandler fh = new FileHandler(LOGFILE, true);
            fh.setFormatter(new SimpleFormatter()); // details from log
            logger.addHandler(fh);
        } catch (IOException e) {
            ConsoleHandler ch = new ConsoleHandler();
            ch.setLevel(Level.ALL);
            logger.addHandler(ch);
            logger.warning(e.toString());
        }
    }

    private FLogger() {
        throw new IllegalStateException("Utility class");
    }

    /*
    * Returns an unique instance from Flogger class
    * to write logs
    *
    * @return the Logger type
    * */
    public static Logger getLogger(){
        return logger;
    }
}
