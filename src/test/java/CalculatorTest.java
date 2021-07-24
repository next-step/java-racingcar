import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    private Calculator calculator = new Calculator();


    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    @NullSource
    @EmptySource
    void inputValidation(String input) {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input));
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @ValueSource(strings = {"2 ^ 3", "2 & 3", "2 ( 3"})
    void invalidOperationSymbolValidation(String input) {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input));
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호인 경우 예외가 발생하지 않는다")
    @ValueSource(strings = {"2 + 3", "2 - 3", "2 * 3 ", "2 / 3"})
    void validOperationSymbolValidation(String input) {
        assertDoesNotThrow(() -> calculator.calculate(input));
    }

}
