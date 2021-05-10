package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(calculator.calculate(first, "/", second)).isEqualTo(3);
    }
}
