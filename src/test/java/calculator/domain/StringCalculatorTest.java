package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName("입력 값이 null 또는 빈 공백 문자일 경우, 예외 발생")
    @NullAndEmptySource
    @ParameterizedTest
    void isNullOrEmpty(String expression) {
        assertThatThrownBy(() -> new StringCalculator(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산 형식대로 입력해 주세요.");
    }

    @DisplayName("사칙연산")
    @ParameterizedTest
    @CsvSource(value = {"2 + 4 * 2:12"}, delimiter = ':')
    void calculate(String expression, double expected) {
        StringCalculator stringCalculator = new StringCalculator(expression);
        assertThat(stringCalculator.calculate()).isEqualTo(expected);
    }
}
