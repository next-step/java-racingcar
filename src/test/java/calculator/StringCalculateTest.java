package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculateTest {

    @ParameterizedTest
    @CsvSource(value = {
        "2 + 3 * 4 / 2,10"
    })
    @DisplayName("입력한 문자열 계산 정상 수행")
    public void calculate(String input, int result) {
        assertThat(StringCalculate.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 empty 입력 값 전달 시 예외")
    public void calculateWithNullAndEmpty(String input) {
        assertThatThrownBy(() -> StringCalculate.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 예외")
    public void calculateWithInvalidOperatorSymbol() {
        assertThatThrownBy(() -> StringCalculate.calculate("2 @ 1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
