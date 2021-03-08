package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    @DisplayName("계산기 테스트")
    void calculator() {
        // when
        String data = "2 + 3 * 4 / 2";

        // when
        int actual = Calculator.calculator(data);

        // then
        int expected = (2 + 3) * 4 / 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("빈값이거나 null 일때 IllegalArgumentException 발생 테스트")
    void hasNotNullOrNotEmpty() {
        // given
        String[] arr = {"2","*","3", " "};

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.hasNotNullOrNotEmpty(arr);
        });
    }

    @Test
    @DisplayName("add 메서드 테스트")
    void add() {
        // given
        int num1 = 5;
        String num2 = "5";

        // when
        int actual = Calculator.add(num1, num2);

        // then
        int expected = num1+Integer.parseInt(num2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("minus 메서드 테스트")
    void minus() {
        // given
        int num1 = 10;
        String num2 = "5";

        // when
        int actual = Calculator.minus(num1, num2);

        // then
        int expected = num1-Integer.parseInt(num2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("multiple 메서드 테스트")
    void multiple() {
        // given
        int num1 = 5;
        String num2 = "5";

        // when
        int actual = Calculator.multiple(num1, num2);

        // then
        int expected = num1*Integer.parseInt(num2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("divide 메서드 테스트")
    void divide() {
        // given
        int num1 = 5;
        String num2 = "5";

        // when
        int actual = Calculator.divide(num1, num2);

        // then
        int expected = num1/Integer.parseInt(num2);
        assertEquals(expected, actual);
    }
}