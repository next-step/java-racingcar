package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private int x;
    private int y;

    @BeforeEach
    public void setArguments() {
        this.x = 3;
        this.y = 2;
    }

    @Test
    @DisplayName("덧셈 연산 테스트")
    void add() {
        int result = StringCalculator.add(x, y);
        assertEquals(result, 5);
    }

    @Test
    @DisplayName("뺄셈 연산 테스트")
    void minus() {
        int result = StringCalculator.minus(x, y);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("곱셈 연산 테스트")
    void multiply() {
        int result = StringCalculator.multiply(x, y);
        assertEquals(result, 6);
    }

    @Test
    @DisplayName("나눗셈 연산 테스트")
    void divide() {
        int result = StringCalculator.divide(x, y);
        assertEquals(result, 1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    void splitExpression(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] arguments = StringCalculator.splitExpression(expression);
        });
    }
}
