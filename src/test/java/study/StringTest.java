package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("String split test")
    @Test
    void split_test1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("Short string split test")
    @Test
    void split_test2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @DisplayName("String substring test")
    @Test
    void substring_test1() {
        String inputStr = "(1,2)";
        String result = inputStr.substring(inputStr.indexOf('(') + 1, inputStr.indexOf(')'));
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String Index OutOfBounds Exception Test")
    @Test
    void test() {
        String inputStr = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> inputStr.charAt(inputStr.length()))
                .withMessageMatching("String index out of range: \\d+");
    }
}
