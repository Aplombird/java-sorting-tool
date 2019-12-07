package diversity.arrays;

import java.util.Comparator;

/**
 * The object of this class is used for comparing objects of DataHolder,
 * which implements the Comparator interface, and it will be utilised as
 * a input parameter when invoke Collections.sort() method for sorting.
 *
 * @author Yongchao Lyu (Yongchao.Lyu@anu.edu.au)
 * @version 1.0
 */
public class DeepCompare implements Comparator<DataHolder> {
    @Override
    public int compare(DataHolder o1, DataHolder o2) {
        return 0;
    }
}
