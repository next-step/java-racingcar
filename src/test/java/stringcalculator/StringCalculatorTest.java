package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
                () -> assertThat(stringCalculator.calculator("2 + 3 * 4 / 2")).isEqualTo(10),
                () -> assertThat(stringCalculator.calculator("1 + 2 - 3")).isEqualTo(0),
                () -> assertThat(stringCalculator.calculator("3 / 2 - 30")).isEqualTo(-29)
        );
    }
}