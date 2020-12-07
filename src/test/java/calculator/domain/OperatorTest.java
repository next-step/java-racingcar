package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @DisplayName("덧셈")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "4:5:9"}, delimiter = ':')
    void add(double num1, double num2, double expected) {
        Operator operator = Operator.findByType("+");
        double result = operator.calculate(num1, num2);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("뺄셈")
    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "9:3:6"}, delimiter = ':')
    void subtract(double num1, double num2, double expected) {
        Operator operator = Operator.findByType("-");
        double result = operator.calculate(num1, num2);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("곱셈")
    @ParameterizedTest
    @CsvSource(value = {"1:-2:-2", "6:7:42", "0:4:0"}, delimiter = ':')
    void multiply(double num1, double num2, double expected) {
        Operator operator = Operator.findByType("*");
        double result = operator.calculate(num1, num2);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("나눗셈")
    @ParameterizedTest
    @CsvSource(value = {"1:-2:-0.5", "4:2:2", "0:4:0"}, delimiter = ':')
    void divide(double num1, double num2, double expected) {
        Operator operator = Operator.findByType("/");
        double result = operator.calculate(num1, num2);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("사칙 연산 기호가 아닐 경우, Exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"$", "#", "@"})
    void not_operator(String type) {
        assertThatThrownBy(() -> Operator.findByType(type))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 연산자입니다.");
    }
}
