
package cc_community.com.mycalculatordemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals("4.0", String.valueOf(MainActivity.getResult("2+2")));
        assertEquals("31.0", String.valueOf(MainActivity.getResult("4×9-5")));
        assertEquals("1.0", String.valueOf(MainActivity.getResult("9×5÷5-8")));

        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();
        List<Object> list4 = new ArrayList<>();
        list1.add(2.0);
        list1.add(2.0);
        list1.add("+");
        list2.add(4.0);
        list2.add(9.0);
        list2.add("×");
        list2.add(5.0);
        list2.add("-");
        list3.add(9.0);
        list3.add(5.0);
        list3.add("×");
        list3.add(5.0);
        list3.add("÷");
        list3.add(8.0);
        list3.add("-");
        list4.add(1.0);
        list4.add(2.0);
        list4.add("+");
        list4.add(3.0);
        list4.add(4.0);
        list4.add("×");
        list4.add(5.0);
        list4.add("÷");
        list4.add("-");
        assertEquals(0.6, MainActivity.getResult("1+2-3×4÷5"),0.01);
        assertEquals("[1.0, 2.0, +, 3.0, 4.0, ×, 5.0, ÷, -]", MainActivity.toSuffix("1+2-3×4÷5").toString());
        assertEquals(0.6, MainActivity.calculate(list4),0.01);
        assertEquals("[4.0, 9.0, ×, 5.0, -]", MainActivity.toSuffix("4×9-5").toString());
        assertEquals("[9.0, 5.0, ×, 5.0, ÷, 8.0, -]", MainActivity.toSuffix("9×5÷5-8").toString());

        assertEquals(list1.toString(), MainActivity.toSuffix("2+2").toString());
        assertEquals(list2.toString(), MainActivity.toSuffix("4×9-5").toString());
        assertEquals(list3.toString(), MainActivity.toSuffix("9×5÷5-8").toString());

        assertEquals("4.0", String.valueOf(MainActivity.calculate(list1)));
        assertEquals("31.0", String.valueOf(MainActivity.calculate(list2)));
        assertEquals("1.0", String.valueOf(MainActivity.calculate(list3)));
    }
}
