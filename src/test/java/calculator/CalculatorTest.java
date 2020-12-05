package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("사칙연산 테스트")
    void four_operator() {
        String input = "3 - 1 + 10 / 2 * 2";
        Calculator calculator = new Calculator();
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("연산 하나 테스트")
    void one_operator() {
        String input = "9 / 3";
        Calculator calculator = new Calculator();
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("연산자 없을때")
    void no_operator() {
        String input = "9";
        Calculator calculator = new Calculator();
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("나누기 0 이 있는 연산 테스트")
    void include_divide_zero() {
        String input = "2 + 4 / 0 * 2";
        Calculator calculator = new Calculator();
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(0);
    }
}