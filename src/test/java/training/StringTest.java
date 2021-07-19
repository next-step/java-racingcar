package training;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringTest {
    @Test
    void 요구사항_1_1() {
        // given
        String[] expected = {"1", "2"};

        // when
        String[] actual = "1,2".split(",");

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 요구사항_1_2() throws Exception {
        // given
        String[] expected = {"1"};

        // when
        String[] actual = "1".split(",");

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 요구사항_2() throws Exception {
        // given
        String expected = "1,2";

        // when
        String actual = "(1,2)".substring(1, 4);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 요구사항_3_1() throws Exception {
        // given
        char expected = 'b';

        // when
        char actual = "abc".charAt(1);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 요구사항_3_2() throws Exception {
        // given
        String expectedMessage = "String index out of range:";

        // when, then
        Assertions.assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageStartingWith(expectedMessage);
    }
}
