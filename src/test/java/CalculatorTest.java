import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void add() {
        int result = Calculator.calc("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtract() {
        int result = Calculator.calc("1 - 2");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void multiply() {
        int result = Calculator.calc("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void divide() {
        int result = Calculator.calc("3 / 2");
        assertThat(result).isEqualTo(1);
    }
}
