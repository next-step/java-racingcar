package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @DisplayName("\"\" 를 입력하면 0을 반환한다")
    @Test
    void emptyInput() {
        int result = StringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("null 을 입력하면 0을 반환한다")
    @Test
    void nullInput() {
        int result = StringCalculator.add(null);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("\"1\" 을 입력하면 1을 반환한다")
    @Test
    void singleNumber() {
        int result = StringCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("기본 구분자로 구분된 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1:2=3", "1,2:3=6"}, delimiter = '=')
    void defaultDelimiters(String input, int expected) {
        assertThat(StringCalculator.add(input)).isEqualTo(expected);
    }

    @DisplayName("\"//;\\n1;2;3\" 을 입력하면 6을 반환한다")
    @Test
    void multipleNumbersWithCustomDelimiter() {
        int result = StringCalculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("\"-1,2\" 를 입력하면 RuntimeException 이 발생한다")
    @Test
    void negativeNumber() {
        assertThatThrownBy(() -> StringCalculator.add("-1,2"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("\"a,1\" 을 입력하면 RuntimeException 이 발생한다")
    @Test
    void nonNumeric() {
        assertThatThrownBy(() -> StringCalculator.add("a,1"))
                .isInstanceOf(RuntimeException.class);
    }
}
