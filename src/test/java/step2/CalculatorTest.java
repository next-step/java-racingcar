package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 테스트 : 1 + 4 = 5")
    void plusTest() {
        String input = "1 + 4";
        assertEquals(5, Calculator.plus(input));
    }

    @Test
    @DisplayName("뺄셈 테스트 : 1 - 4 = -3")
    void minus() {
        String input = "1 - 4";
        assertEquals(-3, Calculator.minus(input));
    }

    @Test
    @DisplayName("곱하기 테스트 : 1 * 4 = 4")
    void multiply() {
        String input = "1 * 4";
        assertEquals(4, Calculator.multiply(input));
    }

    @Test
    @DisplayName("나누기 테스트 : 1 / 4 = 0")
    void divide() {
        String input = "1 / 4";
        assertEquals(0, Calculator.divide(input));
    }
}
