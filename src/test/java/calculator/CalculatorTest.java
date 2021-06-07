package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("입력값은 null이 될 수 없다.")
    @ParameterizedTest
    @NullSource()
    void validateNullExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.makeCalculationResult(input);
        });
    }

    @DisplayName("입력값은 숫자와 연산자만 입력된다.")
    @ParameterizedTest
    @ValueSource(strings = {"a b", "&@", "~!", "1 @", "1 + 2 @"})
    void validateOperatorExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.makeCalculationResult(input);
        });
    }
}
