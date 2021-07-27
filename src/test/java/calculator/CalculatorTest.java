package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void 덧셈() {
        assertThat(calculator.add(1,2)).isEqualTo(3);
        assertThat(calculator.add(2,3)).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(calculator.subtract(1,2)).isEqualTo(-1);
        assertThat(calculator.subtract(3,2)).isEqualTo(1);
    }

    @Test
    void 나눗셈() {
        assertThat(calculator.divide(2, 2)).isEqualTo(1);
        assertThat(calculator.divide(6,2)).isEqualTo(3);
    }

    @Test
    void 곱셈() {
        assertThat(calculator.multiply(2, 2)).isEqualTo(4);
        assertThat(calculator.multiply(6,2)).isEqualTo(12);
    }

}
