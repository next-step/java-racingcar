package calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static calc.ErrorMessage.INVALID_EXPRESSION;
import static calc.ErrorMessage.NOT_NULL;
import static calc.StringCalculatorTestCase.BLANK;
import static calc.StringCalculatorTestCase.DIVIDE_ZERO;
import static calc.StringCalculatorTestCase.HAS_DOUBLE_OPERATOR;
import static calc.StringCalculatorTestCase.HAS_LARGE_NUMBER;
import static calc.StringCalculatorTestCase.HAS_MANY_OPERATOR;
import static calc.StringCalculatorTestCase.HAS_NO_OPERAND;
import static calc.StringCalculatorTestCase.HAS_ONE_OPERATOR;
import static calc.StringCalculatorTestCase.NULL;
import static calc.StringCalculatorTestCase.ONE;
import static calc.StringCalculatorTestCase.PLUS_ONE;
import static calc.StringCalculatorTestCase.START_WITH_MINUS_HAS_LARGE_NUMBER;
import static calc.StringCalculatorTestCase.START_WITH_MINUS_HAS_MANY_OPERATIOR;
import static calc.StringCalculatorTestCase.START_WITH_MINUS_HAS_ONE_OPERATOR;
import static calc.StringCalculatorTestCase.START_WITH_MINUS_ONE;
import static calc.StringCalculatorTestCase.START_WITH_PLUS_HAS_LARGE_NUMBER;
import static calc.StringCalculatorTestCase.START_WITH_PLUS_HAS_MANY_OPERATIOR;
import static calc.StringCalculatorTestCase.START_WITH_PLUS_HAS_ONE_OPERATIOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {ONE, START_WITH_MINUS_ONE, PLUS_ONE, HAS_ONE_OPERATOR,
            START_WITH_MINUS_HAS_ONE_OPERATOR, START_WITH_PLUS_HAS_ONE_OPERATIOR, HAS_ONE_OPERATOR,
            HAS_MANY_OPERATOR, START_WITH_MINUS_HAS_MANY_OPERATIOR,
            START_WITH_PLUS_HAS_MANY_OPERATIOR, HAS_LARGE_NUMBER, START_WITH_MINUS_HAS_LARGE_NUMBER,
            START_WITH_PLUS_HAS_LARGE_NUMBER, DIVIDE_ZERO}, delimiter = '#')
    @DisplayName("문자열 계산기 테스트")
    public void stringCalculatorTest(final String input, final String expected) {

        // when
        int result = StringCalculator.calculate(input);

        // then
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {HAS_NO_OPERAND, HAS_DOUBLE_OPERATOR, BLANK})
    @DisplayName("잘못된 형식의 식 예외 처리 테스트")
    public void invalidExpressionTest(String input) {

        // when, then
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(INVALID_EXPRESSION);
    }

    @Test
    @DisplayName("null 값 예외 처리 테스트")
    public void nullTest() {

        // when, then
        assertThatThrownBy(() -> StringCalculator.calculate(NULL))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(NOT_NULL);
    }
}
