import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        assertThat(Calculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    void subtract() {
        assertThat(Calculator.subtract(2, 1)).isEqualTo(1);
    }

    @Test
    void multiply() {
        assertThat(Calculator.multiply(2, 2)).isEqualTo(4);
    }

    @Test
    void divide() {
        assertThat(Calculator.divide(4, 2)).isEqualTo(2);
    }

    @Test
    void isNull() {
        assertThatThrownBy(() -> {
            new Calculator(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isEmpty() {
        assertThatThrownBy(() -> {
            new Calculator("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5*5/5-5+2-2+1*1", "2*4+2/10", "11+22-22/11"})
    void calculate(String expression) {
        Calculator calculator = new Calculator(expression);
        assertThat(calculator.calculate()).isEqualTo(1);
    }
}