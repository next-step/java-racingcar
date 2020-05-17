package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.Operator.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource(value = { "2, 3, 5.0" })
    @DisplayName("덧셈 테스트")
    void plus(double left, double right, double excepted) {
        double acutal = calculator.calculate(PLUS.symbol, left, right);

        assertThat(acutal).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = { "2, 3, -1.0" })
    @DisplayName("뺄셈 테스트")
    void minus(double left, double right, double excepted) {
        double acutal = calculator.calculate(MINUS.symbol, left, right);

        assertThat(acutal).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = { "2, 3, 6.0" })
    @DisplayName("곱셈 테스트")
    void multiply(double left, double right, double excepted) {
        double acutal = calculator.calculate(MULTIPLY.symbol, left, right);

        assertThat(acutal).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = { "2, 4, 0.5" })
    @DisplayName("나눗셈 테스트")
    void division(double left, double right, double excepted) {
        double acutal = calculator.calculate(DIVISION.symbol, left, right);

        assertThat(acutal).isEqualTo(excepted);
    }

}
