package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");
    }

    @Test
    void charAt() {
        String value = "abc";

        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
