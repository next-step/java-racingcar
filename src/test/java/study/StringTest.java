package study;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String result = "[1,2]".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            "123".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
