package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @DisplayName("null 입력 시 확인")
    @Test
    void inputNullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.validate(null);
        });
    }

    @DisplayName("공백 입력 시 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void inputNullOrBlankTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.validate(input);
        });
    }

    @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 3 - 2 / 2"})
    void allOperatorTest(String input) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(1);
    }
}
