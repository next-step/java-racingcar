package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void split1() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    void advSubstring() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void advCharAt1() {
        String rawString = "abc";

        assertThat(rawString.charAt(0)).isEqualTo('a');
        assertThat(rawString.charAt(1)).isEqualTo('b');
        assertThat(rawString.charAt(2)).isEqualTo('c');
    }

    @Test
    void advCharAt2() {
        String rawString = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
                rawString.charAt(4);
        });
    }

    @AfterEach
    void tearDown() {

    }

}
