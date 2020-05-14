package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;
    
    @BeforeEach
    void setUp() { calculator = new Calculator(); }

    @ParameterizedTest
    @CsvSource({"1 + 1, 2"})
    void 간단한_사칙연산(String equation, Double result) {
        assertThat(calculator.calculate(equation)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({"3 + 1 - 2 / 2, 1"})
    void 복잡한_사칙연산(String equation, Double result) {
        assertThat(calculator.calculate(equation)).isEqualTo(result);
    }
}