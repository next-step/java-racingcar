package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void splitWithSeperatorTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void splitWithoutSeperatorTest() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void chatAtTest() {
        String str = "abc";
        char firstChar = str.charAt(0);
        char thirdChar = str.charAt(2);
        assertThat(firstChar).isEqualTo('a');
        assertThat(thirdChar).isEqualTo('c');
    }

    @Test
    @DisplayName("chatAt method is throwing Exception when index was out of range")
    void chatAtExceptionTest() {
        String str = "abc";
        int outOfRangeIndex = str.length() + 100;
        assertThatThrownBy(() -> {
            str.charAt(outOfRangeIndex);
        }).isInstanceOf(IndexOutOfBoundsException.class);

    }
}
