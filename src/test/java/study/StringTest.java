package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항1 : split() 테스트")
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항2 : substring() 테스트")
    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항3 : charAt() 테스트")
    @Test
    void charAt() {
        char result1 = "abc".charAt(1);
        char result2 = "abc".charAt(2);
        assertThat(result1).isEqualTo('b');
        assertThat(result2).isEqualTo('c');

        assertThatThrownBy(() -> {
            "abc".charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @DisplayName("요구사항3 : charAt() 테스트, assertThatExceptionOfType 활용")
    @Test
    void charAt2() {
        char result1 = "abc".charAt(1);
        char result2 = "abc".charAt(2);
        assertThat(result1).isEqualTo('b');
        assertThat(result2).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(5);
                }).withMessageContaining("index");
    }
}
