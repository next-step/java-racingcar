package study.step_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {

    @Test
    @DisplayName("문자열 1,2를 split했을 때 1과 2로 잘 분리되는지 확인한다")
    void splitShouldReturnMultipleValues() {
        String givenData = "1,2";
        String[] splitData = givenData.split(",");

        assertThat(splitData).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 1을 split했을 때 1만을 포함하는 배열이 반환되는지 확인한다")
    void splitShouldReturnSingleValue() {
        String givenData = "1";
        String[] splitData = givenData.split(",");

        assertThat(splitData).contains("1");
    }

    @Test
    @DisplayName("문자열이 주어졌을 때 substring()을 활용해 괄호를 제거한다")
    void subStringShouldReturnStringWithoutParentheses() {
        String givenData = "(1,2)";
        String result = givenData.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다")
    void charAtShouldReturnTheValueOfIndexZero() {
        String givenData = "abc";
        char result = givenData.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다")
    void charAtShouldThrowStringIndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            String givenData = "abc";
            givenData.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
