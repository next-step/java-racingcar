package study;

import Calculator.Calculator;
import Calculator.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void set() {
        calculator = new Calculator();
    }

    @DisplayName("지원하지 않는 연산자 예외 처리")
    @Test
    void throwIllegalArgumentException() {
        String expression = "2 % 3";

        assertThatThrownBy(() -> calculator.calculate(expression)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 계산기 검사")
    @ParameterizedTest
    @CsvSource({"1 + 2,3", "2 * 3 / 3,2", "-14 / 2,-7"
    })
    void calculateExpression(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }
}
