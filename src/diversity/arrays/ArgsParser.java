package diversity.arrays;

import java.util.*;
import java.util.logging.Logger;

/**
 * The object of this class is used for parsing and holding arguments
 * that read from the command line at the very beginning of the program
 *
 * @author Yongchao Lyu (Yongchao.Lyu@anu.edu.au)
 * @version 1.0
 */
class ArgsParser {
    String filename = null;
    boolean reverse = false;
    Map<String, List<String>> arguments = new HashMap<>();
    private static Logger logger = ToolLogger.getInstance();

    ArgsParser(String[] args) {
        logger.info("Parsing inputted command-line arguments ...");

        // Quit if no arguments are given
        if (args.length == 0) {
            logger.severe("No arguments are given!");
            logger.info("Use command \"java -jar SortingTool.jar -h\" for instruction.");
            System.exit(0);
        }

        if (isMultipleArgumentMode(args)) {
            // Parsing and categorising arguments
            parseArguments(args);

            // Quit if there is any argument cannot be categorised
            if (this.arguments.get("unknown").size() > 0) {
                logger.severe(String.format("Unknown argument type for: %s",
                        String.join(", ", this.arguments.get("unknown"))));
                System.exit(0);
            }

            // Quit if there is no argument following the -f indicator
            if (this.arguments.containsKey("filename")) {
                if(this.arguments.get("filename").size() == 0) {
                    logger.severe("No filename is indicated after -f indicator!");
                    System.exit(0);
                }
                this.filename = this.arguments.get("filename").get(0);
            }

            // Print help info if necessary, and then exit
            if (this.arguments.containsKey("help")) {
                printHelpInfo();
                System.exit(0);
            }

            // Set reverse to true if require for a reverse sorting
            if (this.arguments.containsKey("reverse"))
                this.reverse = true;

        } else {
            // All arguments are used as fields for sorting
            this.arguments.put("object", Arrays.asList(args));
        }

        // Quit if there's no fields given for sorting
        if (this.arguments.get("object").size() == 0) {
            logger.severe("No arguments are given for sorting!");
            System.exit(0);
        }
    }

    // Check if all fields for sorting exist in the source csv file too
    boolean areSortedFieldsLegal(List<String> legalHeads) {
        for (String obj: this.arguments.get("object")) {
            if (!legalHeads.contains(obj)) {
                logger.severe(String.format("No field named \"%s\" can be used for sorting!", obj));
                return false;
            }
        }
        return true;
    }

    // Check whether multiple types of argument are used
    private boolean isMultipleArgumentMode(String[] args) {
        for (String argument: args)
            if (argument.startsWith("-"))
                return true;
        return false;
    }

    // Categorise arguments to specific argument types
    private void parseArguments(String[] args) {
        String argType = "unknown";
        List<String> arguments = new ArrayList<>();
        for (String argument: args) {
            if (argument.startsWith("-")) {
                this.arguments.put(argType, arguments);
                argType = getArgumentType(argument);
                arguments = new ArrayList<>();
            } else {
                arguments.add(argument);
            }
        }
        this.arguments.put(argType, arguments);
    }

    // Convert indicators to argument types
    private String getArgumentType(String argIndicator) {
        switch (argIndicator) {
            case "-h":
                return "help";
            case "-o":
                return "object";
            case "-f":
                return "filename";
            case "-r":
                return "reverse";
            default:
                return "unknown";
        }
    }

    // Print the instruction of this tool
    private void printHelpInfo() {
        System.out.println(
                "\n" +
                "Usage:  java -jar SortingTool.jar -o arg1 arg2 ... [-f filename] [-r] [-h]\n" +
                "\n" +
                "-o arg1 arg2 ... represent the fields used for sorting, separated by whitespace\n" +
                "-f filename      to indicate specific file as the input file\n" +
                "-r               single indicator, used for sorting the data in a reverse order\n" +
                "-h               single indicator, used for printing this instruction\n" +
                "\n" +
                "Note: -o is a mandatory when using -f or -r at the same time.\n" +
                " i.e. -o can be omitted only if -f and -r are unused too.\n" +
                "\n" +
                "Example: java -jar SortingTool.jar -o ENTRY_NO EH_cm -f input-data.csv -r\n" +
                "         java -jar SortingTool.jar ENTRY_NO EH_cm\n"
        );
    }
}
