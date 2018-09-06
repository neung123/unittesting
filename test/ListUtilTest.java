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
}
