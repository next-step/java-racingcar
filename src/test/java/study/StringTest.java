package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1: ,로 split 했을 때 1과 2로 분리")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1: ,로 split 했을 때 1만 반환")
    void split_single_item() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2: () 제거하고 1, 2 반환")
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3: 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 에러")
    void charAt_indexOutOfBoundsException() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(input.length()))
            .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}