package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("문자열 사칙 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 : 10", "40 / 8 : 5", "5 + 2 * 7 : 49", "4 - 2 * 20 / 5 : 8"}, delimiter = ':')
    void calculator(final String str, final int result) {
        assertThat(calculator.calculate(str)).isEqualTo(result);
    }

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "null"})
    void shouldExceptionForNullOrEmptyStrings(final String str) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(str));
    }

    @DisplayName("사칙 연산 기호가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"7 & 8 # 6", "2 $ 5"})
    void shouldExceptionByWrongStrings(final String str) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(str));
    }

    @DisplayName("0으로 나눗셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = "5 + 3 * 4 / 0")
    void shouldExceptionDivideByZero(final String str) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.calculate(str))
                .isInstanceOf(ArithmeticException.class)
                .withMessage("0으로 나눌 수 없습니다.");
    }
}
