package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource({"1, 2, 3", "-1, 10, 9", "0.5, 0.1, 0.6"})
    void plus(double operand1, double operand2, double expected) {
        assertThat(Operator.PLUS.calculate(new Operand(operand1), new Operand(operand2))).isEqualTo(new Operand(expected));
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource({"1, 2, -1", "-1, 10, -11", "0.5, 0.1, 0.4"})
    void minus(double operand1, double operand2, double expected) {
        assertThat(Operator.MINUS.calculate(new Operand(operand1), new Operand(operand2))).isEqualTo(new Operand(expected));
    }

    @DisplayName("곱셉 테스트")
    @ParameterizedTest
    @CsvSource({"1, 2, 2", "-1, 10, -10", "0.5, 0.1, 0.05"})
    void multiply(double operand1, double operand2, double expected) {
        assertThat(Operator.MULTIPLY.calculate(new Operand(operand1), new Operand(operand2))).isEqualTo(new Operand(expected));
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource({"1, 2, 0.5", "-1, 10, -0.1", "0.5, 0.1, 5"})
    void divide(double operand1, double operand2, double expected) {
        assertThat(Operator.DIVIDE.calculate(new Operand(operand1), new Operand(operand2))).isEqualTo(new Operand(expected));
    }
}
