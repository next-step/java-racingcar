package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");

        assertThat(result).contains("1","2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void split3() {
        String[] result = "(1,2)".replace("(", "").replace(")","").split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void charAt1() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                "abc".charAt(3);
            });
    }
}
