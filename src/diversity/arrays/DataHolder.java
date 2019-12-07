package diversity.arrays;

import java.util.Map;

/**
 * The object of this class is used to hold one line of data
 * of the csv input file in a certain format, i.e HashMap
 *
 * @author Yongchao Lyu (Yongchao.Lyu@anu.edu.au)
 * @version 1.0
 */
class DataHolder {
    Map<String, String> data;

    DataHolder(Map<String, String> data) {
        this.data = data;
    }
}
