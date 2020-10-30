package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class OperatorTest {
    @DisplayName("test for `addition(+)` operator")
    @Test
    void add() {
        assertThat(Operator.ADD.operate(5, 5)).isEqualTo(10);
        assertThat(Operator.ADD.operate(5, -5)).isEqualTo(0);
        assertThat(Operator.ADD.operate(0, -5)).isEqualTo(-5);
    }

    @DisplayName("test for `subtraction(-)` operator")
    @Test
    void subtract() {
        assertThat(Operator.SUBTRACT.operate(5, 5)).isEqualTo(0);
        assertThat(Operator.SUBTRACT.operate(0, -5)).isEqualTo(5);
        assertThat(Operator.SUBTRACT.operate(-5, 5)).isEqualTo(-10);
    }

    @DisplayName("test for `multiplication(*)` operator")
    @Test
    void multiply() {
        assertThat(Operator.MULTIPLY.operate(5, 5)).isEqualTo(25);
        assertThat(Operator.MULTIPLY.operate(5, -5)).isEqualTo(-25);
        assertThat(Operator.MULTIPLY.operate(0, -5)).isEqualTo(0);
    }

    @DisplayName("test for `division(/)` operator")
    @Test
    void divide() {
        assertThat(Operator.DIVIDE.operate(0, 5)).isEqualTo(0);
        assertThat(Operator.DIVIDE.operate(4, 5)).isEqualTo(0);
        assertThat(Operator.DIVIDE.operate(5, 3)).isEqualTo(1);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Operator.DIVIDE.operate(5, 0))
                .withMessageMatching(".* by zero$");
    }
}
