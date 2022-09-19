package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result1 = "1,2".split(",");
        assertThat(result1).containsExactly("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("특정 위치의 문자 가져오기")
    void charAtException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {"abc".charAt(-1);})
                .withMessageContaining("String index out of range: %d", -1);
    }
}
