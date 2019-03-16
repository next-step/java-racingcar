package calculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StringAddCalculatorTest {

    @Test
    public void add_null_or_empty() {
        assertEquals(0, StringAddCalculator.add(null));
        assertEquals(0, StringAddCalculator.add(""));
    }

    @Test
    public void add_one_number() {
        assertEquals(1, StringAddCalculator.add("1"));
        assertEquals(2, StringAddCalculator.add("2"));
        assertEquals(3, StringAddCalculator.add("3"));
    }

    @Test
    public void add_two_numbers() {
        assertEquals(2, StringAddCalculator.add("1,1"));
        assertEquals(3, StringAddCalculator.add("1:2"));
        assertEquals(5, StringAddCalculator.add("2,3"));
    }

    @Test
    public void add_three_numbers() {
        assertEquals(6, StringAddCalculator.add("1,2:3"));
        assertEquals(9, StringAddCalculator.add("1:3,5"));
        assertEquals(15, StringAddCalculator.add("3,5,7"));
        assertEquals(24, StringAddCalculator.add("4:8:12"));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative_number() {
        StringAddCalculator.add("-1");
    }

    @Test(expected = RuntimeException.class)
    public void add_negative_number2() {
        StringAddCalculator.add("1,-2");
    }

    @Test(expected = RuntimeException.class)
    public void add_negative_numbers() {
        StringAddCalculator.add("-2:-3");
    }

    @Test(expected = RuntimeException.class)
    public void add_negative_numbers2() {
        StringAddCalculator.add("1,-2:-3");
    }

    @Test
    public void add_with_custom_delimeter() {
        assertEquals(6, StringAddCalculator.add("//;\n1;2;3"));
    }

    @Test
    public void isNullOrEmptyString() {
        assertTrue(StringAddCalculator.isEmpty(""));
        assertTrue(StringAddCalculator.isEmpty(null));
        assertFalse(StringAddCalculator.isEmpty(" "));
        assertFalse(StringAddCalculator.isEmpty("1,2,3"));
    }

    @Test
    public void splitInput() {
        Assert.assertArrayEquals(new String[]{"7", "8", "9"}, StringAddCalculator.splitInput("7,8,9"));
        Assert.assertArrayEquals(new String[]{"33", "75", "64"}, StringAddCalculator.splitInput("33:75:64"));
        Assert.assertArrayEquals(new String[]{"741", "34", "128"}, StringAddCalculator.splitInput("741,34:128"));
        Assert.assertArrayEquals(new String[]{"3", "5", "7"}, StringAddCalculator.splitInput("//;\n3;5;7"));
    }

    @Test
    public void parseIntArray() {
        List<PositiveInteger> expected = Arrays.asList(
                new PositiveInteger(2),
                new PositiveInteger(4),
                new PositiveInteger(6)
        );
        String[] strArray = {"2", "4", "6"};

        List<PositiveInteger> actual = StringAddCalculator.parseIntArray(strArray);

        assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void parseIntArray_when_there_is_negative_integer() {
        StringAddCalculator.parseIntArray(new String[]{"-2", "3", "1"});
    }

    @Test
    public void getSum() {
        List<PositiveInteger> positiveIntegers = Arrays.asList(
            new PositiveInteger(1),
            new PositiveInteger(2),
            new PositiveInteger(3)
        );

        int actual = StringAddCalculator.getSum(positiveIntegers);

        assertEquals(6, actual );
    }
}