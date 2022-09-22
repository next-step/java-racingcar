package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("요구사항1: 문자열 ',' 분리 검증")
    void splitStr() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항2: 문자열 '()' 분리 검증")
    void removeStr() {
        String sampleStr = "(1,2)";
        String result = sampleStr.substring(1, sampleStr.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3: 문자열 범위 에러 검증")
    void errorIndex() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
