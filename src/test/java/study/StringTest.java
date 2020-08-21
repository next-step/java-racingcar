package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split( ",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String result = "1,2".substring("(1,2)");
        assertThat(result).contains("1,2");
    }

    @Test
    public void charAt() {
        assertThatThrownBy(() -> {
           "abc".charAt(2);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
