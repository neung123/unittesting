import java.util.ArrayList;
import java.util.List;

/**
 * A ListUtil class for contain method that can use with List.
 *
 * @Author Pornpavee Seri-umnuoy
 */
public class ListUtil {
    /**
     * Count the number of distinct elements in a list.
     * The list may be empty but not null.
     * The list can contain null values and null count as a unique element.
     *
     * @param list a list of elements
     * @return the number of distinct elements in list
     */
    public static int countUnique(List<?> list) {

        List temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            Object element = list.get(i);
            if(!temp.contains(element)) temp.add(element);
        }
        return temp.size();
    }
}