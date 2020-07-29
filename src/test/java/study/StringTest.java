package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    public void split() {
        String[] result = "1,2".split(",");
        Assertions.assertThat(result).containsExactly("1","2");
    }

    @Test
    public void charAt() {
        Assertions.assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
