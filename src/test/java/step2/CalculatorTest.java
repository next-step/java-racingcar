package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 4,5", "1 - 4,-3", "1 * 4,4", "10 / 2,5"})
    @DisplayName("사칙연산 테스트")
    void eachOperation(String input, int exp) {
        assertEquals(exp, Calculator.calculate(input));
    }

    @Test
    @DisplayName("입력값이 null이면 IllegalArgumentException")
    void isInputNull() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(null));
    }

    @Test
    @DisplayName("입력값이 빈 공백이면 IllegalArgumentException")
    void isInputEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(" "));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 # 4", "1 ! 4", "1 @ 4", "10 & 2"})
    @DisplayName("사칙연산 기호가 아니면 IllegalArgumentException")
    void isOperator(String input) {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(input));
    }

    @Test
    @DisplayName("사칙연산을 모두 포함하는 연산테스트 : 2 + 3 * 4 / 2 = 10")
    void fullOperation() {
        String input = "2 + 3 * 4 / 2";
        assertEquals(10, Calculator.calculate(input));
    }
}
