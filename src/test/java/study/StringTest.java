package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            "123".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).hasSize(2);
        assertThat(result).contains("4");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}
