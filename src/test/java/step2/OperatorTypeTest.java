package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperatorTypeTest {

    @DisplayName("덧셈 테스트")
    @Test
    void plus() {
        OperatorType plus = OperatorType.PLUS;
        int result = plus.operate(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void minus() {
        OperatorType minus = OperatorType.MINUS;
        int result = minus.operate(5, 2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiply() {
        OperatorType multiply = OperatorType.MULTIPLY;
        int result = multiply.operate(3, 7);
        assertThat(result).isEqualTo(21);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void divide() {
        OperatorType divide = OperatorType.DIVIDE;
        int result = divide.operate(6, 3);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("0으로 나눌 시 ArithmeticException 발생")
    @Test
    void divide_ThrowsArithmeticException_IfDivideByZero() {
        OperatorType divide = OperatorType.DIVIDE;
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> divide.operate(6, 0));
    }
}
