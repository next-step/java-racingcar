package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationTest {

    Operation operation = new Operation();

    @BeforeEach
    void setUp() {
    }

    @Test
    void add() {
        assertThat(operation.add(1, 2)).isEqualTo(1 + 2);
    }

    @Test
    void subtract() {
        assertThat(operation.subtract(1, 2)).isEqualTo(1 - 2);
    }

    @Test
    void multiply() {
        assertThat(operation.multiply(1, 2)).isEqualTo(1 * 2);
    }

    @Test
    void divide() {
        assertThat(operation.divide(4, 2)).isEqualTo(4 / 2);
    }

    @Test
    void divideByZero() {
        assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> operation.divide(1, 0));
    }

    @Test
    void calculate() {
        assertThat(operation.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    void invalidExpressionOperand() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> operation.calculate(" + "));
    }

    @Test
    void invalidExpressionOperator() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> operation.calculate("1 ? 2"));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> operation.calculate("2 2 2"));
    }

}