package diversity.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The object of this class is used for parsing and holding arguments
 * that read from the command line at the very beginning of the program
 *
 * @author Yongchao Lyu (Yongchao.Lyu@anu.edu.au)
 * @version 1.0
 */
class ArgsParser {
    Map<String, List<String>> arguments = new HashMap<>();
    private static Logger logger = ToolLogger.getInstance();

    ArgsParser(String[] args) {
        logger.info("Parsing inputted command-line arguments ...");

        if (args.length == 0) {
            logger.severe("No arguments are given for sorting!");
            System.exit(0);
        }
        this.arguments.put("object", Arrays.asList(args));
    }

    boolean areSortedFieldsLegal(List<String> legalHeads) {
        for (String obj: this.arguments.get("object")) {
            if (!legalHeads.contains(obj)) {
                logger.severe(String.format("No field named \"%s\" can be used for sorting!", obj));
                return false;
            }
        }
        return true;
    }
}
