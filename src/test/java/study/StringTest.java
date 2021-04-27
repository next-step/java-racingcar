package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {


    @Test
    void splitWithComma() {
        final String[] test = "1,2".split(",");
        Assertions.assertArrayEquals(new String[]{"1", "2"}, test);
        assertThat(test).contains(new String[]{"1", "2"}); // same
        assertThat(test).containsExactly("1", "2");

        final String[] test2 = "1".split(",");
        Assertions.assertArrayEquals(new String[]{"1"}, test2);
    }

    @Test
    void Calculate() {
        final Calculator calculator = new Calculator();

        Assertions.assertEquals(5, calculator.add(3, 2));
        assertThat(calculator.add(3, 2)).isEqualTo(5); // same
    }

    @Test
    void Delete() {
        String test = "(1,2)";
        test = test.replaceAll("\\(", "").replaceAll("\\)", "");
        assertThat(test).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Must Occurs Error")
    void GetChar() {

        assertThatThrownBy(() -> {
            final String test = "abc";
            final char test2 = test.charAt(0);
            assertThat(test2).isEqualTo('a');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}