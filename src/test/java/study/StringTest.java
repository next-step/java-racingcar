package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 반환 값 테스트")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring을 통한 맨 앞, 맨 뒤 제거 값 테스트")
    void substring() {
        String result = "(1,2)";
        result = result.substring(1, result.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt - StringIndexOutOfBoundsException 예외 테스트")
    void stringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        })
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                "abc".charAt(3);
            })
            .withMessageMatching("String index out of range: \\d+");
    }
}
