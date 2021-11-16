package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void splitWithoutDelimiter() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    @DisplayName("chatAt으로 특정 위치의 문자를 가져온다.")
    void charAt(int index, char result) {
        char actual = "abc".charAt(index);
        assertThat(actual).isEqualTo(result);
    }

    @Test
    @DisplayName("Index 범위를 벗어난 chatAt")
    void chatAtIndexOutOfBounds() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessage("String index out of range: 3");
    }
}
