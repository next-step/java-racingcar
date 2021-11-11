package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @Test
    void add() {
        Operand result = new Operand(1).add(new Operand(2));
        assertThat(result).isEqualTo(new Operand(3));
    }

    @Test
    void subtract() {
        Operand result = new Operand(1).subtract(new Operand(2));
        assertThat(result).isEqualTo(new Operand(-1));
    }

    @Test
    void multiply() {
        Operand result = new Operand(1).multiply(new Operand(2));
        assertThat(result).isEqualTo(new Operand(2));
    }

    @Test
    void divide() {
        Operand result = new Operand(1).divide(new Operand(2));
        assertThat(result).isEqualTo(new Operand(0));
    }

    @Test
    void divideByZero() {
        assertThatThrownBy(() -> new Operand(1).divide(new Operand(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다");
    }

}
