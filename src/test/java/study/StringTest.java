package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String[] result = "(1,2)".substring(1,4).split(",");
        assertThat(result).containsExactly("1","2");

    }

    @Test
    public void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }


}
