package calculatorTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import calculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("Test for 'stringCalculator'")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2, 10", "3 * 20 + 100 / 10 - 30, -14"})
    void stringCalculateTest(String input, int expected) {
        assertThat(calculator.stringCalculate(input)).isEqualTo(expected);
    }

    @DisplayName("입력값이 null")
    @ParameterizedTest
    @NullAndEmptySource
    void stringCalculateTestByNull(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.stringCalculate(input));
    }

    @DisplayName("입력값이 빈 공백")
    @ParameterizedTest
    @NullAndEmptySource
    void stringCalculateTestByEmptySpace(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.stringCalculate(input));
    }

    @DisplayName("사칙연산 기호가 아님")
    @ParameterizedTest
    @ValueSource(strings = {"2 ^ 3 ! 4 # 2"})
    void stringCalculateTestByInvalidSymbol(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.stringCalculate(input));
    }
}
