package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringClassTest {

    private final String ABC = "abc";
    private final int ABC_LENGTH = ABC.length();

    @Test
    @DisplayName("쉼표(,)로 split시 1과 2로 분리")
    void splitComma() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("쉼표(,)로 split시 1만 포함하는 배열의 반환")
    void splitCommaWithOneValue() {
        // given
        String input = "1";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메소드로 (1,2)에서 괄호()를 제거하고 1,2 반환")
    void removeParenthesesUsingSubstring() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, input.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드로 마지막 위치의 문자열 반환")
    void getCharAtTheLastPosition() {
        // when
        char result = ABC.charAt(ABC_LENGTH - 1);

        // then
        assertThat(result).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() 메소드로 범위를 벗어난 위치 값을 가져올 때 예외 발생")
    void getCharAtOutOfBounds__ShouldReturnIndexOutOfBoundsException() {
        // when, then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() ->
                        ABC.charAt(ABC_LENGTH)
                ).withMessageMatching("String index out of range: \\d+");
    }
}
