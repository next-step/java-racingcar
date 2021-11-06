package calculate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperateTest {
    @Test
    void add() {
        assertThat(Operate.ADD.calculate(1, 3)).isEqualTo(4);
    }

    @Test
    void subtract() {
        assertThat(Operate.SUBTRACT.calculate(1, 3)).isEqualTo(-2);
    }

    @Test
    void multiply() {
        assertThat(Operate.MULTIPLY.calculate(4, 3)).isEqualTo(12);
    }

    @Test
    void divide() {
        assertThat(Operate.DIVIDE.calculate(6, 3)).isEqualTo(2);
    }

    @Test
    void divideWithZero() {
        assertThatThrownBy(() -> {
            Operate.DIVIDE.calculate(6, 0);
        }).isInstanceOf(ArithmeticException.class);
    }
}
