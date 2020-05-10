package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @DisplayName("하나의 문자를 분리하는 경우 해당 문자를 포함하는 배열을 반환한다")
    @Test
    void splitChar() {
        String input = "1";
        String[] result = input.split(",");
        assertThat(result).contains("1");
    }

    @DisplayName("여러 문자를 쉼표(,) 구분자로 구분하는 경우 각 문자로 분리된 배열 반환한다")
    @Test
    void split() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("문자열에 포함된 괄호 문자들을 제거한 경우 괄호 문자가 제거된 문자열을 반환한다")
    @Test
    void subString() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("문자열의 특정 위치의 문자를 가져온다")
    @Test
    void charAt() {
        String input = "abc";
        char result = input.charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @DisplayName("문자열의 범위를 벗어난 위치의 문자를 가져오는 경우 예외가 발생한다")
    @Test
    void charAtThrown() {
        String input = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(input.length()));
    }
}
