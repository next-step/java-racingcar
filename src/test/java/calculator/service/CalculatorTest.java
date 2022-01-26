package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.Formula;
import calculator.domain.Operation;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void run(){
        String formula = "1 + 3 - 5";
        double result = Calculator.run(new Formula(formula));
        assertThat(result).isEqualTo(-1);
    }
}