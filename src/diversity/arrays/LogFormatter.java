package diversity.arrays;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class LogFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return new Date(record.getMillis()) + "::"
                + record.getLevel() + "::"
                + record.getSourceClassName() + "::"
                + record.getSourceMethodName() + "::"
                + record.getMessage() + "\n";
    }
}
