package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열을 반환한다.")
    @Test
    void split1() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 분리된다.")
    @Test
    void split2() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환한다.")
    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("abc 값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAt(int input, char expected) {
        String string = "abc";
        assertThat(string.charAt(input)).isEqualTo(expected);
    }

    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    public void charAtException() {
        String string = "abc";

        assertThatThrownBy(() -> {
            string.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    string.charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }

}
