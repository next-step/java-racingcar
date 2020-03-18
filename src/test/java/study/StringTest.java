package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("컴마(,) 를 구분자로 하여 문자를 분리한다.")
    @Test
    void split() {
        String[] results = "1,2".split(",");
        assertThat(results).containsExactly("1", "2");
    }

    @DisplayName("첫번째와 마지막 문자를 제거한다.")
    @Test
    void substring() {
        String text = "(1,2)";
        text = text.substring(1, text.length() - 1);

        assertThat(text).isEqualTo("1,2");
    }

    @DisplayName("문자열 길이에서 벗어나는 위치를 참조해본다.")
    @Test
    void charAt() {
        assertThatThrownBy(() -> {
            String text = "abc";
            text.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("Index: \\d+, Size: \\d+");
    }
}
