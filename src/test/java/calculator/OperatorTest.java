package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {


    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @CsvSource(value = {"1:+:2:3:", "-1:+:-2:-3"}, delimiter = ':')
    @DisplayName("덧셈 계산")
    void add(int number1, String operator, int number2, int expected) {
        assertThat(Operator.calculate(operator, number1, number2)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @CsvSource(value = {"1:-:2:-1", "-1:-:-2:1"}, delimiter = ':')
    @DisplayName("뺄셈 계산")
    void minus(int number1, String operator, int number2, int expected) {
        assertThat(Operator.calculate(operator, number1, number2)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @CsvSource(value = {"1:*:2:2", "-1:*:-2:2"}, delimiter = ':')
    @DisplayName("곱셈 계산")
    void multi(int number1, String operator, int number2, int expected) {
        assertThat(Operator.calculate(operator, number1, number2)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @CsvSource(value = {"2:/:1:2", "3:/:-1:-3"}, delimiter = ':')
    @DisplayName("나눗셈 계산")
    void divide(int number1, String operator, int number2, int expected) {
        assertThat(Operator.calculate(operator, number1, number2)).isEqualTo(expected);
    }

}
