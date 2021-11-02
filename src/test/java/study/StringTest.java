package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    private static final int PADDING = 1;
    private static final String COMMA = ",";

    @Test
    @DisplayName("요구사항1 : ,(comma) 로 구분되어 있는 값을 split 했을 때 comma 의 개수 + 1 개의 원소로 분리되어야 한다.")
    void splitTest1() {
        String[] result = "1,2".split(COMMA);
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1 : ,(comma) 로 구분되어 있지 않은 값을 split 했을 때 단일 원소만 반환해야한다.")
    void splitTest2() {
        String[] result = "1".split(COMMA);
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 : 문자열 양 끝의 괄호를 제거한다.")
    void substringTest() {
        String input = "(1,2)";
        String result = input.substring(PADDING, input.length() - PADDING);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 : charAt() 을 사용할 때 문자열 범위를 넘어서면 예외가 발생한다.")
    void charAtExceptionTest() {
        String input = "abc";
        assertThatThrownBy(() -> input.charAt(input.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + input.length());
    }
}
