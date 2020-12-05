package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void 사칙연산_테스트() {
        String input = "3 - 1 + 10 / 2 * 2";
        Calculator calculator = new Calculator();
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 연산_하나_테스트() {
        String input = "9 / 3";
        Calculator calculator = new Calculator();
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 연산자_없을때() {
        String input = "9";
        Calculator calculator = new Calculator();
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(9);
    }
}