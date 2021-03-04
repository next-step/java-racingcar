package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("피연산자가 부족할 경우 예외를 던진다.")
    void throwExceptionIfOperandIsNotEnough() {
        String expression = "2 + 5 * 4 / 2 -";

        assertThatThrownBy(() -> calculator.calculate(expression)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("지원하지 않는 연산자가 포함되어 있다면 예외를 던진다.")
    void throwExceptionIfInvalidOperatorExist() {
        String expression = "2 % 11";

        assertThatThrownBy(() -> calculator.calculate(expression)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Null 또는 빈 문자열이 입력되면 예외를 던진다.")
    void throwExceptionIfInputIsNullOrEmptyString() {
        assertAll(
            () -> assertThatThrownBy(() -> calculator.calculate(null))
                .isInstanceOf(RuntimeException.class),
            () -> assertThatThrownBy(() -> calculator.calculate(""))
                .isInstanceOf(RuntimeException.class)
        );
    }

    @ParameterizedTest(name = "수식을 연산자 우선순위 없이 계산한다. - 식: {0}")
    @CsvSource({
        "1 + 2,3",
        "25 * 17 / 3,141",
        "-14 / 2 * 3 + 5,-16"
    })
    void calculateExpression(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

}
