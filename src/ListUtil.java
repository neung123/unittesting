import java.util.ArrayList;
import java.util.Arrays;
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

    public static <T extends Comparable<? super T>> int binarySearch(T[] array, T element){

        if(element == null) throw new IllegalArgumentException("Search element must not be null");

        Arrays.sort(array);
        int start = 0;
        int end = array.length-1;
        int position;

        while (end >= start) {
            position = (start + end) / 2;
            if (element.compareTo(array[position]) == 0) return position;
            else if (element.compareTo(array[position]) > 0) start = position + 1;
            else end = position - 1;
        }
        return  -1;
    }
}