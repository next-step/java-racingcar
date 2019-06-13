package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_으로_첫번째_문자를_가져온다() {
        String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
    }

    @Test
    void charAt은_위치를_벗어나면_예외를_발생시킨다() {
        String input = "abc";

        assertThatThrownBy(() -> {
            input.charAt(-1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }

    @AfterEach
    void tearDown() {

    }
}