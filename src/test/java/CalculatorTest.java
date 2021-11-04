import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void longInput() {
        int result = Calculator.calc("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void nullInput() {
        assertThatThrownBy(() -> {
            Calculator.calc(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void operatorError() {
        assertThatThrownBy(() -> {
            Calculator.calc("1 ^ 2");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
