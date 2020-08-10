package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {

    private int x;
    private int y;

    @BeforeEach
    public void setArguments() {
        this.x = 3;
        this.y = 2;
    }

    @Test
    @DisplayName("사칙연산 기호 테스트")
    void isOperator() {
        assertThat(Operator.of("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.of("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    @DisplayName("사친연산 기호가 아닌 경우")
    void isNotOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator operator = Operator.of("!");
        }).withMessage(ExceptionMessage.NOT_ARITHMETIC_OPERATOR.getMessage());
    }

    @Test
    @DisplayName("덧셈 연산 테스트")
    void add() {
        int result = Operator.PLUS.compute(x, y);
        assertEquals(result, 5);
    }

    @Test
    @DisplayName("뺄셈 연산 테스트")
    void minus() {
        int result = Operator.MINUS.compute(x, y);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("곱셈 연산 테스트")
    void multiply() {
        int result = Operator.MULTIPLY.compute(x, y);
        assertEquals(result, 6);
    }

    @Test
    @DisplayName("나눗셈 연산 테스트")
    void divide() {
        int result = Operator.DIVIDE.compute(x, y);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("0으로 나누는 경우")
    void divideWithIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            int result = Operator.DIVIDE.compute(x, 0);
        }).withMessage(ExceptionMessage.DIVIDED_BY_ZERO.getMessage());
    }
}
