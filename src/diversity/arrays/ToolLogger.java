package diversity.arrays;

import java.io.IOException;
import java.util.logging.*;

/**
 * The object of this class is used for setting a logger with specific
 * output format that used to record log for all classes in the project.
 *
 * @author Yongchao Lyu (Yongchao.Lyu@anu.edu.au)
 * @version 1.0
 */
class ToolLogger {
    private static Logger logger = null;

    private ToolLogger() {
    }

    static Logger getInstance() {
        if (logger == null) {
            logger = Logger.getLogger("SortingToolLogger");
            logger.setLevel(Level.FINE);

            // Add console handler
            Handler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new LogFormatter());
            logger.addHandler(consoleHandler);

            // Add file handler
            try {
                String LOG_FILE = "logger.log";
                int FILE_SIZE = 5000000;    // Unit: bytes
                int FILE_AMOUNT = 1;        // Max number of log files

                Handler fileHandler = new FileHandler(LOG_FILE, FILE_SIZE, FILE_AMOUNT);
                fileHandler.setFormatter(new LogFormatter());
                logger.addHandler(fileHandler);

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // Disable logger to send output to its parent logger
            logger.setUseParentHandlers(false);
        }
        return logger;
    }
}
