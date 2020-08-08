package study;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String[] valuse = "3 + 4".split(" ");
        assertThat(valuse).containsExactly("3", "+", "4");
    }


    @Test
    public void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }


}
