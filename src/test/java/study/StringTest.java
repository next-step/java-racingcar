package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void charAt() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    throw new IllegalArgumentException();
                });
    }

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).hasSize(2);
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}
