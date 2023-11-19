package calculator.application;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {
    @Test
    void calculateTest() {
        double result = CalculatorService.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10.00);
    }
}
