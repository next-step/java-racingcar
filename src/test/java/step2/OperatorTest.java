package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.Operator;

class OperatorTest {
    @ParameterizedTest
    @CsvSource({ "2, 3, 5" })
    @DisplayName("더하기")
    void plus(double left, double right, double expected) {
        assertThat(Operator.PLUS.calculate(left, right)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({ "2, 3, -1" })
    @DisplayName("뺴기")
    void minus(double left, double right, double expected) {
        assertThat(Operator.MINUS.calculate(left, right)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({ "2, 3, 6" })
    @DisplayName("곱하기")
    void multiply(double left, double right, double expected) {
        assertThat(Operator.MULTIPLY.calculate(left, right)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({ "2, 4, 0.5" })
    @DisplayName("나누기")
    void division(double left, double right, double expected) {
        assertThat(Operator.DIVISION.calculate(left, right)).isEqualTo(expected);
    }
}
