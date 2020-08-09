package step2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    static Calculator calculator;

    @BeforeAll
    public static void create() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("덧셈")
    public void add() {
        Integer value =  OperatorType.searchOperation("+").calculate(1, 3);
        assertEquals(value, 4);
    }

    @Test
    @DisplayName("뺄셈")
    public void minus() {
        Integer value =  OperatorType.searchOperation("-").calculate(1, 2);
        assertEquals(value, -1);
    }

    @Test
    @DisplayName("곱셈")
    public void multipication() {
        Integer value =  OperatorType.searchOperation("*").calculate(2, 2);
        assertEquals(value, 4);
    }

    @Test
    @DisplayName("나눗셈")
    public void divide() {
        Integer value =  OperatorType.searchOperation("/").calculate(5, 2);
        assertEquals(value, 2);
    }

    @DisplayName("입력 값이 빈공백, null일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @NullAndEmptySource
    public void inputBrankOrNull(String input) {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input));
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"5 dd 5 / 2"})
    public void inputNotOperand(String input) {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input));
    }

    @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
    @ParameterizedTest(name = "{index} {displayName} {0} = {1}")
    @CsvSource({"2 + 3 * 4 / 2, 10", "3 * 5 / 2, 7", "10 + 100 * 5 / 2, 275"})
    public void implementationFunction(String input, Integer result) {
        assertEquals(calculator.calculate(input), result);
    }







}