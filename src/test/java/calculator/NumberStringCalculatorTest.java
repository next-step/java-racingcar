package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberStringCalculatorTest {
    @Test
    void additionTest() {
        NumberCalculator numberCalculator = new NumberCalculator();
        int first = 3;
        int second = 4;
        Assertions.assertThat(numberCalculator.addition(first,second)).isEqualTo(7);
    }

    @Test
    void subtractionTest() {
        NumberCalculator numberCalculator = new NumberCalculator();
        int first = 3;
        int second = 4;
        Assertions.assertThat(numberCalculator.subtraction(first,second)).isEqualTo(-1);
    }

    @Test
    void multiplicationTest() {
        NumberCalculator numberCalculator = new NumberCalculator();
        int first = 3;
        int second = 4;
        Assertions.assertThat(numberCalculator.multiplication(first,second)).isEqualTo(12);
    }

    @Test
    void divisionTest() {
        NumberCalculator numberCalculator = new NumberCalculator();
        int first = 12;
        int second = 4;
        Assertions.assertThat(numberCalculator.division(first,second)).isEqualTo(3);
    }
}
