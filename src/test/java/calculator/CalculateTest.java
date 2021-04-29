package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateTest {
    @Test
    void additionTest() {
        Calculate calculate = new Calculate();
        int first = 3;
        int second = 4;
        Assertions.assertThat(calculate.addition(first,second)).isEqualTo(7);
    }

    @Test
    void subtractionTest() {
        Calculate calculate = new Calculate();
        int first = 3;
        int second = 4;
        Assertions.assertThat(calculate.subtraction(first,second)).isEqualTo(-1);
    }

    @Test
    void multiplicationTest() {
        Calculate calculate = new Calculate();
        int first = 3;
        int second = 4;
        Assertions.assertThat(calculate.multiplication(first,second)).isEqualTo(12);
    }

    @Test
    void divisionTest() {
        Calculate calculate = new Calculate();
        int first = 12;
        int second = 4;
        Assertions.assertThat(calculate.division(first,second)).isEqualTo(3);
    }
}
