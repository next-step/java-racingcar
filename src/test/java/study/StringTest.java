package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Created by wyparks2@gmail.com on 2019-06-13
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class StringTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result[0]).isEqualTo("1");
        assertThat(result[1]).isEqualTo("2");
    }

    @Test
    void split2() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void chartAt() {
        final String input = "abc";

        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    void chartAtException() {
        final String input = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    assertThat(input.charAt(5)).isEqualTo('a');
                }).withMessageContaining("String index out of range:");
    }

    @AfterEach
    void tearDown() {

    }

}
