package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void plus() {
        assertThat(stringCalculator.plus(1, 2)).isEqualTo(3);
    }

    @Test
    void minus() {
        assertThat(stringCalculator.minus(3, 2)).isEqualTo(1);
    }
}