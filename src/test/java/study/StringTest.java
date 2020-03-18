package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("this is test")
public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자 가지고 오기 테스트")
    void charAtMessageContaining() {
        assertThatThrownBy(() -> {
            char result = "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d+");
    }

    @Test
    @DisplayName("IS this?")
    void charAtMessageMatch() {

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = "abs".charAt(3);
                }).withMessageMatching("[A-Za-z ]* range: [0-9]*");
    }
}
