package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result.length).isEqualTo(2);
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result.length).isEqualTo(1);
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring1() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void chatAt1() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    void chatAtException1() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = "abc".charAt(5);
                })
    }
}
