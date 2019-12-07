package diversity.arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The object of this class is used for reading and verifying
 * the csv input file, and processing the data into a certain
 * data structure that will be employed later for sorting.
 *
 * @author Yongchao Lyu (Yongchao.Lyu@anu.edu.au)
 * @version 1.0
 */
class FileHolder {
    List<DataHolder> dataList;

    private static final String DEFAULT_FILENAME = "input-data.csv";
    private static Logger logger = ToolLogger.getInstance();

    private String filename;
    private File fileHandler;
    private List<List<String>> rawData = new ArrayList<>();

    FileHolder() {
        this(DEFAULT_FILENAME);
    }

    FileHolder(String filename) {
        this.filename = filename;
        this.fileHandler = new File(filename);
        this.dataList = new ArrayList<>();

        // Check whether the file exist
        if (!fileHandler.exists()) {
            logger.severe(String.format("Input file %s does not exist!", filename));
            System.exit(0);
        }

        // Check whether the data read is complete
        if (!(readCsvFile() && isDataComplete())) {
            logger.severe(String.format("Read process of %s is incomplete!", filename));
            System.exit(0);
        }

        // Format the raw data to a list of DataHolder objects
        if (!formatRawData()) {
            logger.severe(String.format("Format process of %s is incomplete!", filename));
            System.exit(0);
        }
    }

    private boolean readCsvFile() {
        try {
            FileReader fileReader = new FileReader(this.fileHandler);
            BufferedReader csvReader = new BufferedReader(fileReader);

            String line;
            while ((line = csvReader.readLine()) != null)
                this.rawData.add(Arrays.asList(line.split(",")));

            csvReader.close();
            fileReader.close();
            return true;

        } catch (IOException ex) {
            logger.severe(String.format("Reading file error: %s", ex.toString()));
            return false;
        }
    }

    private boolean isDataComplete() {
        // Check whether the data read from the input file has available values
        // If data.size is 0, means an exception occurred when reading, or the input file is totally empty
        // If data.size is 1, means the input file only contains the row of title without any row of values
        if (this.rawData.size() < 2) {
            logger.severe(String.format("Data read from file %s is empty!", this.filename));
            return false;
        }

        // Check whether all rows contain the same number of values as the titles
        List<String> keys = this.rawData.get(0);
        for (int index = 1; index < this.rawData.size(); index++) {
            List<String> line_values = this.rawData.get(index);
            if (keys.size() != line_values.size()) {
                logger.severe(String.format("The number of values given in line %d is incorrect", index + 1));
                return false;
            }
        }

        return true;
    }

    private List<String> elementStripper(List<String> originalList) {
        return originalList.stream().map(String::strip).collect(Collectors.toList());
    }

    private boolean formatRawData() {
        try {
            List<String> keys = elementStripper(this.rawData.get(0));
            for (int index = 1; index < this.rawData.size(); index++) {
                List<String> values = elementStripper(this.rawData.get(index));
                Map<String, String> data = IntStream.range(0, keys.size()).boxed()
                        .collect(Collectors.toMap(keys::get, values::get));
                this.dataList.add(new DataHolder(data));
            }
            return true;

        } catch (RuntimeException ex) {
            logger.severe(String.format("Formatting data error: %s", ex.toString()));
            return false;
        }
    }
}
