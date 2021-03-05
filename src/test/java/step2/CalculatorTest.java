package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("입력값이 null이면 IllegalArgumentException")
    void isInputNull() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.plus(null));
        assertThrows(IllegalArgumentException.class, () -> Calculator.minus(null));
        assertThrows(IllegalArgumentException.class, () -> Calculator.multiply(null));
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(null));
    }

    @Test
    @DisplayName("입력값이 빈 공백이면 IllegalArgumentException")
    void isInputEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.plus(" "));
        assertThrows(IllegalArgumentException.class, () -> Calculator.minus(" "));
        assertThrows(IllegalArgumentException.class, () -> Calculator.multiply(" "));
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(" "));
    }

    @Test
    @DisplayName("사칙연산 기호가 아니면 IllegalArgumentException")
    void isOperator() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.plus("1 # 3"));
        assertThrows(IllegalArgumentException.class, () -> Calculator.minus("1 ! 3"));
        assertThrows(IllegalArgumentException.class, () -> Calculator.multiply("1 @ 3"));
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide("1 ^ 3"));
    }

    @Test
    @DisplayName("사칙연산을 모두 포함하는 연산테스트 : 2 + 3 * 4 / 2 = 10")
    void operation() {
        String input = "2 + 3 * 4 / 2";
        assertEquals(10, Calculator.calculate(input));
    }
}
