package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("스플릿 결과가 2개일 경우 스플릿이 잘 되는지 확인")
    @Test
    void splitTwoTest() {
        final String input = "1,2";
        final String delimiter = ",";

        String[] splitResult = input.split(delimiter);

        assertThat(splitResult).contains("1", "2");
    }

    @DisplayName("스플릿 결과가 하나일 경우 스플릿이 잘 되는지 확인")
    @Test
    void splitOneTest() {
        final String input = "1";
        final String delimiter = ",";

        String[] splitResult = input.split(delimiter);

        assertThat(splitResult).containsExactly("1");
    }

    @DisplayName("subString 메소드가 정상 동작하는지 확인")
    @Test
    void subStringTest() {
        final String input = "(1,2)";
        final String expected = "1,2";

        String substringResult = input.substring(1, 4);

        assertThat(substringResult).isEqualTo(expected);
    }

    @DisplayName("charAt 메소드가 정상 동작하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    void charAtTest(int index, char expected) {
        final String input = "abc";

        char result = input.charAt(index);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("charAt 메소드 사용 시 인덱스가 벗어난 경우 예외 처리 확인")
    @Test
    void charAtIndexOutOfBoundExceptionTest() {
        final String input = "abc";
        final int inputIndex = 3;

        assertThatThrownBy(() -> input.charAt(inputIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + inputIndex);
    }
}
