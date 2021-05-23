package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void additionTest() {
        double first = 3;
        double second = 4;

        assertThat(calculator.calculate(first, "+", second)).isEqualTo(7);
    }

    @Test
    void subtractionTest() {
        double first = 3;
        double second = 4;

        assertThat(calculator.calculate(first, "-", second)).isEqualTo(-1);
    }

    @Test
    void multiplicationTest() {
        double first = 3;
        double second = 4;

        assertThat(calculator.calculate(first, "*", second)).isEqualTo(12);
    }

    @Test
    void divisionTest() {
        double first = 12;
        double second = 4;
        double zero = 0;

        assertThat(calculator.calculate(first, "/", second)).isEqualTo(3);
        assertThrows(IllegalArgumentException.class,()->{
            calculator.calculate(first, "/", zero);
        });
    }
}
