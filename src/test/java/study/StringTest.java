package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void splitTestFirst() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
        assertThat(result).hasSize(2);
    }

    @Test
    void splitTestSecond() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
        assertThat(result).hasSize(1);
    }

    @Test
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져온다. 단, 범위를 벗어나면 예외가 발생한다.")
    @Test
    void charAtTest() {
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> "abc".charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
