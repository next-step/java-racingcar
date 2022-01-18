package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 더하기() {
        int result = Calculator.add(3, 7);
        assertThat(result).isEqualTo(10);
    }
}