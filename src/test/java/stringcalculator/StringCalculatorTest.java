package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @DisplayName("입력값에 따라 사칙 연산을 정상적으로 수행")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 + 1 + 1:3", "10 + 11 - 10 * 3 / 3:11", "1 + 2 - 1 * 2 / 8:0.5"}, delimiter = ':')
    void calculate(String input, double expected) {
        StringCalculator stringCalculator = new StringCalculator(input);

        assertThat(stringCalculator.calculate()).isEqualTo(expected);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @NullAndEmptySource
    void calculateFailByNullOrEmptyInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new StringCalculator(input));
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 @ 2"})
    void calculateFailByInvalidOperator(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);

        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate());
    }

    @DisplayName("0로 나누었을때 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 0"})
    void calculateFailByDivideZero(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);

        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate());
    }

    @DisplayName("숫자가 아닌 값이 포함 될 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"2 + d * 4 / 0"})
    void calculateFailByInvalidNumber(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);

        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate());
    }
}
