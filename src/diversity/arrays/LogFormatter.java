package diversity.arrays;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * The object of this class is used for providing a specific output format
 * to the object of one kind of log handler class, such as ConsoleHandler.
 *
 * @author Yongchao Lyu (Yongchao.Lyu@anu.edu.au)
 * @version 1.0
 */
class LogFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return new Date(record.getMillis()) + "::"
                + record.getLevel() + "::"
//                + record.getSourceClassName() + "::"
//                + record.getSourceMethodName() + "::"
                + record.getMessage() + "\n";
    }
}
