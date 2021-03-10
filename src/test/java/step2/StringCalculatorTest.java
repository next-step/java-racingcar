package step2;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = " ")
    @DisplayName("Null 또는 공백을 입력")
    void inputNullOrBlank(String input)  {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(input))
            .withMessageMatching(Constants.INPUT_NULL_OR_EMPTY);
    }

    @ParameterizedTest
    @ValueSource(strings = "3 + x / 1")
    @DisplayName("숫자가 아닌 문자를 입력")
    void inputNotNumeric(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(input))
            .withMessageMatching(Constants.INPUT_NUMERIC);
    }

    @ParameterizedTest
    @ValueSource(strings = "1 & 2 + 3")
    @DisplayName("사칙연산 기호가 아닌 문자를 입력")
    void inputInvalidSymbol(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(input))
            .withMessageMatching(Constants.INVALID_SYMBOL);
    }

    @ParameterizedTest
    @CsvSource(value = {"9 + 1 * 5 / 2, 25", "2 - 1 * 3 + 1, 4", "9 + 1 - 2 * -3, -24"})
    @DisplayName("문자열 계산기 테스트")
    void calculate(String input, int expected) {
        assertEquals(expected, stringCalculator.calculate(input));
    }

}
