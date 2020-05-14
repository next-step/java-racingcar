package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;
    
    @BeforeEach
    void setUp() { calculator = new Calculator(); }

    @Test
    void 간단한_사칙연산() {
        Double firstNumber = 1D;
        Double secondNumber = 1D;
        String symbol = "+";
        assertThat(calculator.calculate(firstNumber, secondNumber, symbol)).isEqualTo(2D);
    }
}