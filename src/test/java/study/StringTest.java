package study;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 메소드 학습 테스트 - 성공")
    @Test
    void charAt1() {
        String input = "abc";
        char result = input.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @DisplayName("charAt 메소드 학습 테스트 - 실패")
    @Test
    void charAt2() {
        String input = "abc";
        int outOfBoundIndex = 4;

        assertThatThrownBy(() -> {
            input.charAt(outOfBoundIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + outOfBoundIndex);
    }

}
