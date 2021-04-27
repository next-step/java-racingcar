package study;
//import jdk.internal.joptsimple.internal.Strings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.AssertTrue.assertTrue;

public class StringTest {
    @Test
    void split() {
        System.out.println(11111);
        final String[] actual = "1,2".split(",");
//        String[] temp = new String[2];
        String[] temp = {"1", "2"};
//        assertThat(temp).contains(actual);
        assertThat(temp).containsExactly(actual);
    }

    @Test
    void test2() {
        String actual = "(1,2)";
        actual = actual.replaceAll("\\(", "").replaceAll("\\)","");
//        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
//        actual = actual.replaceAll(match, "");

        Assertions.assertEquals(actual, "1,2");
    }

//    @DisplayName("테스트 할껀데요?")
    @Test
    void test3() {
//        try {
//        } catch (IndexOutOfBoundsException e) {
//        }

        assertThatThrownBy(() -> {
            String actual = "abc";
            int index = actual.indexOf("e");
            String lastChar = Character.toString(actual.charAt(index));
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("e");
    }

    @Test
    void cal_add() {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.subtract(2, 1));
        System.out.println(calculator.multiply(1, 2));
        System.out.println(calculator.divide(12, 2));
    }

    @Test
    void cal1() {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> {
//            calculator.calculate(1, '+', 2);
            calculator.calculate(1, '#', 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void cal2() {
        Calculator calculator = new Calculator();
//        assertThatThrownBy(() -> {
//            calculator.makeResult("1 ");
//        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        Calculator calculator = new Calculator();

        assertTrue(calculator.isBlank(input));
    }
}