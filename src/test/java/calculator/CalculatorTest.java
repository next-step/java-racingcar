package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new calculator.Calculator();
    }

    @DisplayName("사칙연산")
    @ParameterizedTest
    @CsvSource(value = { "+:10", "-:6", "*:16", "/:4", "+ 10 / 2 - 3 *:12" }, delimiter = ':')
    void calculateTest(String symbol, String result) {
        assertThat(calculator.inputer("8 " + symbol + " 2"))
                .isEqualTo(result);
    }

    @DisplayName("예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"5 % 3", " ", "3 3"})
    void exceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.inputer(input));
    }

}
