package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("문자열 계산기 테스트")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 = 10", "2 + 3 - 1 * 4 / 2 = 8", "2 + 3 = 5", "2 - 3 = -1", "3 * 4 = 12", "4 / 2 = 2"}, delimiter = '=')
    @DisplayName("사칙연산")
    void calculator(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    void throwIllegalArgumentExceptionIfInputIsNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 # 2"})
    @DisplayName("사칙연산 기호가 아닌 경우")
    void throwIllegalArgumentExceptionIfInputContainsIllegalOperation(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }

}
