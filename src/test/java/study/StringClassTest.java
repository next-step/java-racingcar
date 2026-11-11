package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringClassTest {
    @Test
    void splitIntoArray() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitIntoSingleElementArray() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void getCharAt() {
        char result = "abc".charAt(1);

        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열 길이 밖 인덱스를 지정하면 StringIndexOutOfBoundsException을 던진다")
    void getCharAtOutOrIndex() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            "abc".charAt(3);
        }).withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }
}
