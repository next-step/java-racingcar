package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    public void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("2", "1");
//        assertThat(result).containsExactly("2", "1");
    }

    @Test
    public void charAt() {
        assertThatThrownBy(
                () -> "abc".charAt(3)
        ).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}