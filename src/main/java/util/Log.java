package util;

import java.util.logging.Logger;

/**
 * Created by gabri on 2016-06-09.
 */
public class Log {

    static Logger logger = Logger.getLogger(Log.class.getName());

    public static void servere(String msg) {
        logger.severe(msg);
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void fine(String msg) {
        logger.fine(msg);
    }

    public static void info(String msg, Object category) {
        info(category.getClass().getName() + ": " + msg);
    }
}
