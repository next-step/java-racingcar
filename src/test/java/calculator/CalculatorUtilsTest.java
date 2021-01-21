package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class CalculatorUtilsTest {

    @Test
    void addTest() {
        assertThat(CalculatorUtils.add(1, 2)).isEqualTo(3);
    }

    @Test
    void subtractTest() {
        assertThat(CalculatorUtils.subtract(1,2)).isEqualTo(-1);
    }

    @Test
    void multiplyTest() {
        assertThat(CalculatorUtils.multiply(1,2)).isEqualTo(2);
    }

    @Test
    void divideTest() {
        assertThat(CalculatorUtils.divide(1,2)).isEqualTo(0);
    }
}