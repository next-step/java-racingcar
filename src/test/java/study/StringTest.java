package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("String#split 의 학습테스트")
    void split() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("String#substring 의 학습테스트")
    void substring() {
        assertThat(stripBracket("(1,2)")).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String#charAt 의 학습테스트")
    void charAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("String#charAt 예외 학습테스트")
    void charAtException() {
        String input = "abc";
        int outOfBoundIndex = input.length() + 1;

        assertThatThrownBy(() -> {
            input.charAt(outOfBoundIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class) //
                .hasMessage("String index out of range: %d", outOfBoundIndex);
    }

    private String stripBracket(String input) {
        return input.substring(input.indexOf("(") + 1, input.indexOf(")"));
    }
}
