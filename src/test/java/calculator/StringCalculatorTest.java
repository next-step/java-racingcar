package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static calculator.StringCalculator.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @MethodSource("operatorProvider")
    void operatorTest(int num1, StringCalculator.Operator operator, int num2, int expectedResult) {
        assertCalculate(num1, operator, num2, expectedResult);
    }

    static Object[] operatorProvider() {
        return new Object[]{
                new Object[]{1, PLUS, 2, 3},
                new Object[]{3, MINUS, 2, 1},
                new Object[]{3, MULTIPLY, 2, 6},
                new Object[]{4, DIVIDE, 2, 2}
        };
    }

    @Test
    void divideByZeroThanFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.Operator.DIVIDE.calculator(4, 0));
    }

    private void assertCalculate(int num1, StringCalculator.Operator operator, int num2, int expectedResult) {
        assertThat(stringCalculator.calculate(num1, operator, num2)).isEqualTo(expectedResult);
    }
}