package calculator;

import calculator.exception.InvalidDenominatorException;
import calculator.exception.InvalidInputException;
import calculator.exception.NumericException;
import calculator.exception.OperatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("계산 검증")
    @ParameterizedTest(name = "{index}번째 => {0} 연산결과 : {1}")
    @CsvSource(value = {
            "3 + 4 + 5 - 2 / 4 | 2",
            "3 + 4 - 5 * 2 / 4 | 1",
            "5 / 2 - 3 | -1",
            "2 + 3 * 4 / 2 | 10"
    }, delimiter = '|')
    void calculateTest(String input, Long expected) {
        assertThat(calculator.execute(input)).isEqualTo(expected);
    }

    @DisplayName("입력된 값이 null이거나 공백일경우 예외발생")
    @ParameterizedTest
    @NullAndEmptySource
    void inputNullAndEmptyTest(String input) {
        assertThatThrownBy(() -> calculator.execute(input))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(CalculatorValidator.INVALID_INPUT_MESSAGE);
    }

    @DisplayName("잘못된 연산자 예외발생")
    @ParameterizedTest(name = "{index}번째 => 예외발생")
    @ValueSource(strings = {
            "3 + 4 % 5 - 2 / 4",
            "3 + 4 - 5 * 2 % 4",
            "5 ^ 2 - 3 | -1",
            "2 ^ 3 # 4 / 2"
    })
    void calculateExceptionTest1(String input) {
        assertThatThrownBy(() -> calculator.execute(input))
                .isInstanceOf(OperatorException.class)
                .hasMessage(CalculatorValidator.INVALID_OPERATOR_MESSAGE);
    }

    @DisplayName("나눗셈 중 분모가 0일 경우 예외발생")
    @ParameterizedTest(name = "{index}번째 => 예외발생")
    @ValueSource(strings = {
            "3 + 4 / 0 - 2 / 4",
            "3 + 4 - 5 * 2 / 0",
    })
    void calculateExceptionTest2(String input) {
        assertThatThrownBy(() -> calculator.execute(input))
                .isInstanceOf(InvalidDenominatorException.class)
                .hasMessage(CalculatorValidator.INVALID_DENOMINATOR_MESSAGE);
    }

    @DisplayName("입력된 첫번째값이 숫자가 아닐경우 예외발생")
    @ParameterizedTest(name = "{index}번째 => 예외발생")
    @ValueSource(strings = {
            "str + 4 / 0 - 2 / 4",
            "d2f + 4 - 5 * 2 + 3",
            "2f12 + 4 - 5 * 2 * 5",
    })
    void calculateExceptionTest3(String input) {
        assertThatThrownBy(() -> calculator.execute(input))
                .isInstanceOf(NumericException.class)
                .hasMessage(CalculatorValidator.INVALID_INPUT_MESSAGE);
    }
}