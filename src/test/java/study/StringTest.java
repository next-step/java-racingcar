package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {
    @Test
    @DisplayName("split")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("구분자 없는 문자열 split")
    void splitSingle() {
        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 앞뒤 자르기")
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("위치에 해당되는 문자 반환")
    void charAt() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("위치에 해당되는 문자 반환 - IndexOutOfBoundsException")
    void chatAtException() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(4);
                });
    }
}
