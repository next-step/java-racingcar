package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void spiltTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subStringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 경우")
    @Test
    void charAtTest() {
        char result1 = "abc".charAt(0);
        assertThat(result1).isEqualTo('a');

        char result2 = "abc".charAt(1);
        assertThat(result2).isEqualTo('b');

        char result3 = "abc".charAt(2);
        assertThat(result3).isEqualTo('c');
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치 값을 벗어난 경우")
    @ParameterizedTest
    @ValueSource(strings = "abc")
    void charAtIndexOutOfBoundsExceptionTest(final String input) {
        assertThatThrownBy(() -> {
            char result = input.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }
}
