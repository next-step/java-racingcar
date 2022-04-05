package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항 1: split 테스트")
    void splitTest() {
        String[] result1 = "1,2".split(",");
        assertThat(result1).contains("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2: substring 테스트")
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3: charAt 테스트")
    void charAtTest() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> "abc".charAt(-1)).isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThatThrownBy(() -> "abc".charAt(5)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
