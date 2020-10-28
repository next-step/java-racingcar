package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("입력한 문자열 값에 따라 사칙연산을 수행")
    void calculator() {
        assertAll(
                () -> assertThat(stringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10),
                () -> assertThat(stringCalculator.calculate("1 + 2 - 3")).isEqualTo(0),
                () -> assertThat(stringCalculator.calculate("3 / 2 - 30")).isEqualTo(-29)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    void calculator_failingCase_nullOrEmptyInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> stringCalculator.calculate(input));
    }
}