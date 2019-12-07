package diversity.arrays;

import java.util.Comparator;
import java.util.List;

/**
 * The object of this class is used for comparing objects of DataHolder,
 * which implements the Comparator interface, and it will be utilised as
 * a input parameter when invoke Collections.sort() method for sorting.
 *
 * @author Yongchao Lyu (Yongchao.Lyu@anu.edu.au)
 * @version 1.0
 */
public class DeepCompare implements Comparator<DataHolder> {
    private List<String> orderBy;

    DeepCompare(List<String> orderBy) {
        this.orderBy = orderBy;
    }

    private int recursiveCompare(DataHolder o1, DataHolder o2, int index) {
        if (index < orderBy.size()) {
            String field = orderBy.get(index);

            // Strip blank characters before comparing
            String v1 = o1.data.get(field).strip();
            String v2 = o2.data.get(field).strip();

            // Recursive comparing when the values of current field are equal
            // Switch to next field via index. Note: "".equals("") is true
            if (v1.equals(v2))
                return recursiveCompare(o1, o2, index + 1);

            // Compare two different values of current field
            if (!v1.isBlank() && !v2.isBlank()) {
                try {
                    Double d1 = Double.parseDouble(v1);
                    Double d2 = Double.parseDouble(v2);
                    return d2 - d1 > 0 ? 1 : -1;

                } catch (NumberFormatException ex) {
                    return v1.compareTo(v2);
                }
                // The empty value win the non-empty value
                // i.e. non-empty value will place prior to empty value
            } else {
                return v1.isBlank() ? 1 : -1;
            }
        }
        return 0;
    }

    @Override
    public int compare(DataHolder o1, DataHolder o2) {
        return recursiveCompare(o1, o2, 0);
    }

    @Override
    public Comparator<DataHolder> reversed() {
        return (DataHolder o1, DataHolder o2) -> -1 * compare(o1, o2);
    }
}
