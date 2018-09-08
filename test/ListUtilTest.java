import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListUtilTest {

    @Test
    public void testEmptyList(){
        assertEquals(0, ListUtil.countUnique(createList()));
    }

    @Test
    public void testListSizeOne(){
        assertEquals(1, ListUtil.countUnique(createList("one")));
    }

    @Test
    public void testListOneElement(){
        assertEquals(1, ListUtil.countUnique(createList("one", "one", "one")));
    }

    @Test
    public void testListOfTwoItemManyOrders(){
        assertEquals(2, ListUtil.countUnique(createList("a", "b")));
        assertEquals(2, ListUtil.countUnique(createList("a", "b", "a", "b", "a", "b", "b")));
    }

    @Test
    public void testListOfMixTypeElement(){
        assertEquals(4, ListUtil.countUnique(createList("a", 1, 45.03, 'r')));
        assertEquals(4, ListUtil.countUnique(createList("a", 1, 45.03, 'r', "a", 1, 45.03, 'r', 'r')));
        assertEquals(3, ListUtil.countUnique(createList(1, 1D, "1")));
    }

    @Test
    public void testLargeList(){
        List large = new ArrayList();
        for (int i = 1; i <= 10000; i++ ) large.add(i);
        assertEquals(10000, ListUtil.countUnique(large));
    }

    @Test
    public void testNullElement(){
        assertEquals(1, ListUtil.countUnique(createList(null, null)));
    }

    private List<?> createList(Object ... element){
        return java.util.Arrays.asList(element);
    }

    /** Binary Test **/
    @Test
    public void testBinarySearchEmpty(){
        assertEquals(-1, ListUtil.binarySearch(new String[]{}, "Hello"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBinarySearchNull(){
         ListUtil.binarySearch(new Double[]{1.5, 2.4, 3.1, 4.9, 5D}, null);
    }

    @Test
    public void testBinarySearchNotInArray(){
        assertEquals(-1, ListUtil.binarySearch(new String[]{"Hello"}, "Hi"));
    }

    @Test
    public void testBinarySearchOneElement(){
        assertEquals(0, ListUtil.binarySearch(new String[]{"Hello"}, "Hello"));
    }

    @Test
    public void testBinarySearchMidArray(){
        assertEquals(2, ListUtil.binarySearch(new String[]{"Absorb", "Defense", "Shield", "Water"}, "Shield"));
        assertEquals(2, ListUtil.binarySearch(new String[]{"Water", "Absorb", "Defense", "Shield"}, "Shield"));

        assertEquals(0, ListUtil.binarySearch(new Double[]{1.5, 2.4, 3.1, 4.9, 5D}, 1.5));
        assertEquals(4, ListUtil.binarySearch(new Double[]{1.5, 2.4, 3.1, 4.9, 5D}, 5.0));
        assertEquals(2, ListUtil.binarySearch(new Double[]{1.5, 2.4, 3.1, 4.9, 5D}, 3.1));
        assertEquals(3, ListUtil.binarySearch(new Double[]{1.5, 2.4, 3.1, 4.9, 5D}, 4.9));
    }

    @Test
    public void testBinarySearchLargeArray(){
        Double array[] = new Double[10000];
        for (int i = 0; i < array.length; i++ ) array[i] = i+1D;
        assertEquals(0, ListUtil.binarySearch(array, 1D));
        assertEquals(9_999, ListUtil.binarySearch(array, 10_000D));
        assertEquals(88, ListUtil.binarySearch(array, 89D));
    }
}
