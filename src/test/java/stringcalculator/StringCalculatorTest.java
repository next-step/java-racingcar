package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "  "})
    void exceptionByNullOrEmpty(String input) {
        StringCalculator cal = new StringCalculator();

        assertThatThrownBy(() -> cal.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4 % 2", "6 @ 3", "4 ( 2", "8 ) 4"})
    void exceptionByNoOperator(String input) {
        StringCalculator cal = new StringCalculator();

        assertThatThrownBy(() -> cal.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 순서에 따라 사칙연산을 한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2$10"
            , "2 + 3 * 4 / 10$2"
            , "1 + 3 / 2 * 5$10"}
            , delimiter = '$')
    void calculate(String input, int expected) {
        StringCalculator cal = new StringCalculator();

        int actual = cal.calculate(input);

        assertEquals(expected, actual);
    }
}
