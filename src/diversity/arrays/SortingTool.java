package diversity.arrays;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The main class of this project, which assemble all components
 * of the project to perform desired actions.
 * <p>
 * Basic Features:
 * - Reads in a CSV file, which uses a identical filename as "input-data.csv".
 * - Takes in arguments for at least 2 columns (e.g., eh2 -eh4), only the fields used for sorting.
 * - Can sort according to the specified columns, larger numbers first for numbers and in alphabetical order for others.
 * - Prints the top 3 results in a YAML format, including row, column, and fields used for sorting.
 *
 * @author Yongchao Lyu (Yongchao.Lyu@anu.edu.au)
 * @version 1.0
 */
public class SortingTool {
    private static Logger logger = ToolLogger.getInstance();

    public static void main(String[] args) {
        logger.info("Welcome to use this sorting tool.");

        // Read arguments from the command line
        ArgsParser argsParser = new ArgsParser(args);
        List<String> orderBy = argsParser.arguments.get("object");

        // Read input csv file and process data
        FileHolder fileHolder = new FileHolder();
        List<DataHolder> dataList = fileHolder.dataList;

        // Check whether the objects for sorting are legal
        if (argsParser.areSortedFieldsLegal(fileHolder.heads)) {
            // Sort the data basing on certain fields
            DeepCompare deepCompare = new DeepCompare(orderBy);
            dataList.sort(deepCompare);

            // Output the results in the yaml format
            printTop3Result(dataList, orderBy);
            logger.info("All tasks are done.");
        }
    }

    private static void printTop3Result(List<DataHolder> dataList, List<String> orderBy) {
        System.out.println("\noutput:");
        for (int index = 0; index < Math.min(3, dataList.size()); index++) {
            Map<String, String> data = dataList.get(index).data;

            StringBuilder sortedFields = new StringBuilder();
            for (String field: orderBy)
                sortedFields.append(String.format("%s=%s ", field, data.get(field)));

            System.out.println(String.format(
                    "- row: %s\n" +
                    "  column: %s\n" +
                    "  data: %s",

                    data.get("row"),
                    data.get("column"),
                    sortedFields.toString()
            ));
        }
        System.out.println();
    }
}
