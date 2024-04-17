package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void studyStringSplit() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void studyStringSubstring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt()의 기능을 테스트하고 문자열의 range를 벗어나면 exception이 발생하는 학습 테스트를 구현한다")
    void studyStringcharAt() {
        char result = "(1,2)".charAt(2);
        assertThat(result).isEqualTo(',');
        assertThatThrownBy(() -> {
            "(1,2)".charAt(20);
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of bounds for length");
        assertThatThrownBy(() -> {
            "(1,2)".charAt(-10);
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of bounds for length");
    }
}
