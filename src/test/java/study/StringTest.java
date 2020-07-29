package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    public void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
