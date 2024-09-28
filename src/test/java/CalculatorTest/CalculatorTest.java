package CalculatorTest;

import Calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    void emptyStringTest() {
        Integer result = calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void nullTest() {
        Integer result = calculator.calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void calculateSingleIntegerTest() {
        String input = "3";
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(3);
    }


    @Test
    void calculateMultipleIntegerTest() {
        String input = "1,2,3";
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void collonSpliterTest() {
        String input = "1,2;3";
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void customSpliterTest() {
        String input = "//;\\n1;2;3";
        Integer result = calculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void notIntegerInputExceptionTest() {
        String input = "1,a,3";
        assertThatThrownBy(() -> {
            calculator.calculate(input);
        })
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void negativeNumberInputExceptionTest() {
        String input = "1,-2,3";
        assertThatThrownBy(() -> {
            calculator.calculate(input);
        })
                .isInstanceOf(RuntimeException.class);
    }
}
