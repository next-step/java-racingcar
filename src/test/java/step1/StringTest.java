package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).contains("1","2");

        final String[] actual2 = "1".split(",");
        assertThat(actual2).containsExactly("1");
    }

    @Test
    void substring() {
        final String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("")
    void charAt() {
        final char c = "abc".charAt(2);
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("assertThatExceptionOfType 사용한 Exception 처리")
    void charAtException() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c2 = "abc".charAt(3);
                    assertThat(c2).isEqualTo('c');
                }).withMessageMatching("index out of range: [0-9]");
    }
}
