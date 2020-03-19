package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("문자열 계산기는 \"1+3\"을 입력받아 4를 반환해야 한다")
    @Test
    void calculatorWorks() {
        Calculator calculator = new Calculator();
        int sum = calculator.calc("1+3");
        assertThat(sum).isEqualTo(4);
    }

    @DisplayName("문자열 계산기는 덧셈을 할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1+3=4", "3+3=6", "1+1+1=3", "5+4+3=12"}, delimiter = '=')
    void calculatorCanSum(String expression, int expected) {
        Calculator calculator = new Calculator();
        int sum = calculator.calc(expression);
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("문자열 계산기는 사칙연산을 함께 수행할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1+3-3=1", "4/2+3*2=10", "5-3+1*3+2=11", "5+4-3=6"}, delimiter = '=')
    void calculatorCanOperationsZ(String expression, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.calc(expression);
        assertThat(result).isEqualTo(expected);
    }
}