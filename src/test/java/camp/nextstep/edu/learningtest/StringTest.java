package camp.nextstep.edu.learningtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@SuppressWarnings("NonAsciiCharacters")
class StringTest {

    @Test
    void splitTest() {
        String input = "1,2";
        String[] results = input.split(",");

        assertThat(results).contains("2", "1");
        assertThat(results).containsExactly("1", "2");
        assertThat(results.length).isEqualTo(2);
        assertThat(results[0]).isEqualTo("1");
        assertThat(results[1]).isEqualTo("2");
    }

    @Test
    void splitTest2() {
        String input = "1";
        String[] results = input.split(",");

        assertThat(results).containsExactly("1");
    }

    @Test
    void substringTest() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_유효한_입력이면_성공() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    void charAt_문자열_길이보다_크면_실패() {
        String input = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }
}
