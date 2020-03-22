package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("계산기에 null 이나 공백을 넣으면 IllegalArgumentException")
    void inputIsZeroOrNullTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 = 10",
                        "2 / 2 - 2 * 0 + 1 = 1",
                        "1 = 1",
                        "3 + 3 + 3 = 9",
                        "0 / 1 = 0"}, delimiter = '=')
    void calculateTest(String input, String expected) {
        assertThat(calculator.calculate(input)).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 & 2"})
    @DisplayName("사칙 연산 기호가 아닌 경우 IllegalArgumentException")
    void calculateExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }
}