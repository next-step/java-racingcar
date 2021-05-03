package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void additionTest() {
        int first = 3;
        int second = 4;
        Assertions.assertThat(calculator.calculate(first,"+",second)).isEqualTo(7);
    }

    @Test
    void subtractionTest() {
        int first = 3;
        int second = 4;
        Assertions.assertThat(calculator.calculate(first,"-",second)).isEqualTo(-1);
    }

    @Test
    void multiplicationTest() {
        int first = 3;
        int second = 4;
        Assertions.assertThat(calculator.calculate(first,"*",second)).isEqualTo(12);
    }

    @Test
    void divisionTest() {
        int first = 12;
        int second = 4;
        Assertions.assertThat(calculator.calculate(first,"/",second)).isEqualTo(3);
    }

    @Test
    void enumTest() {
        Assertions.assertThat(MathSymbol.PLUS.getMathSymbol()).isEqualTo("+");
    }
}
