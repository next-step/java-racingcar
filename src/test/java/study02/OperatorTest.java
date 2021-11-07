package study02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

    @Test
    @DisplayName("Bifunction 덧셈")
    void bifunction_덧셈() {
        assertThat(Operator.ADDITION.operate(new MyNumber(1), new MyNumber(2))).isEqualTo(new MyNumber("3"));
    }

    @Test
    @DisplayName("Bifunction 뺄셈")
    void bifunction_뺄셈() {
        assertThat(Operator.SUBTRACTION.operate(new MyNumber(5), new MyNumber(4))).isEqualTo(new MyNumber("1"));
    }

    @Test
    @DisplayName("Bifunction 나눗셈")
    void bifunction_나눗셈() {
        assertThat(Operator.DIVISION.operate(new MyNumber(9), new MyNumber(3))).isEqualTo(new MyNumber("3"));
    }

    @Test
    @DisplayName("Bifunction 곱셈")
    void bifunction_곱셈() {
        assertThat(Operator.MULTIPLICATION.operate(new MyNumber(10), new MyNumber(2))).isEqualTo(new MyNumber("20"));
    }

    @Test
    @DisplayName("유효하지 않은 수식기호")
    void invalidOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.of("%"));
    }
}