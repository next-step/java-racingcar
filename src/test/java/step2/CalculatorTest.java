package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("실제 연산처리 테스트")
    void getResult() {
        // given
        String[] arr = {"2", "+", "5", "*", "4", "/", "2"};

        // when
        int actual = Calculator.getResult(arr);

        // then
        int expected = (2 + 5) * 4 / 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("연산자에 따라 연산 테스트")
    void chooseOperator() {
        // given
        String operator = "*";
        int result = 20;
        String num2 = "10";

        // when
        int actual = Calculator.chooseOperator(operator, result, num2);

        // then
        int expected = result * Integer.parseInt(num2);
        assertEquals(actual, expected);

    }

    @Test
    @DisplayName("데이터 파싱한 배열에서 null 또는 빈 값 검사")
    void hasNotNullOrNotEmpty() {
        // given
        String[] arr = {"2", "*", "3"};

        // when & then
        assertTrue(Calculator.hasNotNullOrNotEmpty(arr));
    }

    @Test
    @DisplayName("빈 값이거나 null 일때 IllegalArgumentException 발생 테스트")
    void throwIllegalArgumentException() {
        // given
        String s = " ";

        // when && then
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.throwIllegalArgumentException(s);
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
        int expected = num1 + Integer.parseInt(num2);
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
        int expected = num1 - Integer.parseInt(num2);
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
        int expected = num1 * Integer.parseInt(num2);
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
        int expected = num1 / Integer.parseInt(num2);
        assertEquals(expected, actual);
    }
}