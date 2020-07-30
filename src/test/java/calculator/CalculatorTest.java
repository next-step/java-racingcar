package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void addtion() {
        Assertions.assertThat(calculator.addtion(1,4)).isEqualTo(5);
    }

    @Test
    public void subtract() {
        Assertions.assertThat(calculator.subtract(10,4)).isEqualTo(6);
    }

    @Test
    public void division() {
        Assertions.assertThat(calculator.division(8,4)).isEqualTo(2);
    }

    @Test
    public void multiplication() {
        Assertions.assertThat(calculator.multiplication(10,4)).isEqualTo(40);
    }
}
