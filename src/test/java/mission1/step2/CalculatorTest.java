package mission1.step2;

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

    @DisplayName("피연산자가 숫자가 아닌 경우 NumberFormatException throw")
    @ParameterizedTest
    @ValueSource(strings = {"ss dd 5 / 2"})
    public void inputNotOperator (String input) {
        assertThrows(NumberFormatException.class, () -> calculator.calculate(input));
    }

    @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
    @ParameterizedTest(name = "{index} {displayName} {0} = {1}")
    @CsvSource({"2 + 3 * 4 / 2, 10", "3 * 5 / 2, 7", "10 + 100 * 5 / 2, 275"})
    public void implementationFunction(String input, Integer result) {
        assertEquals(calculator.calculate(input), result);
    }
}






