package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
