package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitStringWithoutDelimiter() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드에서 위치 값이 문자열의 범위를 벗어나면 에러가 발생한다.")
    @Test
    void charAt() {
        assertThatThrownBy(() -> "abc".charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
