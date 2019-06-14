package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void calculator() {
        assertThat(stringCalculator.calculate("1 + 2 * 3")).isEqualTo(9);
        assertThat(stringCalculator.calculate("4 / 2 - 1")).isEqualTo(1);
        assertThat(stringCalculator.calculate("4 / 2 - 1 * 3")).isEqualTo(3);
        assertThat(stringCalculator.calculate("4 / 2 - 1 * 3")).isEqualTo(3);
    }

    @Test
    void splitInputString() {
        String[] result = stringCalculator.split("1 + 2");
        assertThat(result).containsExactly("1", "+", "2")
                .hasSize(3);
    }

    @DisplayName("입력 값이 공백 또는 Null 일 경우 Exception")
    @ParameterizedTest
    @NullAndEmptySource
    void inputNullAndEmptyThenFail(String inputNullAndEmpty) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.calculate(inputNullAndEmpty));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 10 +", "1_2", "1^+^10^/^20"})
    void splitWrongDelimiters(String wrongInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.split(wrongInput))
                .withMessageMatching("구분자는 공백을 사용합니다.");
    }
}