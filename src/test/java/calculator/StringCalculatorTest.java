package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static calculator.StringCalculator.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void calculator() {
        assertThat(stringCalculator.calculate("1 + 2 * 3")).isEqualTo(9);
        assertThat(stringCalculator.calculate("4 / 2 - 1")).isEqualTo(1);
        assertThat(stringCalculator.calculate("4 / 2 - 1 * 3 ")).isEqualTo(3);
    }

    @Test
    void operatorWrongSymbolThanFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.Operator.from("^"));
    }

    @Test
    void split() {
        String[] result = stringCalculator.split("1 + 2");
        assertThat(result).containsExactly("1", "+", "2")
                          .hasSize(3);
    }

    @DisplayName("입력 값이 공백 또는 Null일 경우 Exception")
    @ParameterizedTest
    @NullAndEmptySource
    void inputString2(String inputNullAndEmpty) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.split(inputNullAndEmpty));
    }

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
    @DisplayName("제수가 0일 경우 Exception")
    void divideByZeroThanFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> DIVIDE.calculator(4, 0));
    }

    private void assertCalculate(int num1, StringCalculator.Operator operator, int num2, int expectedResult) {
        assertThat(stringCalculator.calculate(num1, operator, num2)).isEqualTo(expectedResult);
    }
}