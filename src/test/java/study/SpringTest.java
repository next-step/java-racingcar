package study;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SpringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
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
    void stringIndexOutOfBoundsException() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }

}
