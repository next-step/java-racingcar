package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculateTest {

    @ParameterizedTest
    @CsvSource(value = {
        "2 + 3 * 4 / 2,10",
        "1,1",
        "1 + 3,4",
        "10 - 5,5",
        "4 * 6,24",
        "10 / 2,5",
        "1 + 2 + 3 + 4 * 2 - 2 / 9,2"
    })
    @DisplayName("입력한 문자열 계산 정상 수행")
    public void calculate(String input, int result) {
        assertThat(StringCalculate.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 empty 입력 값 전달 시 예외")
    public void calculateWithNullAndEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculate.calculate(input));
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 예외")
    public void calculateWithInvalidOperatorSymbol() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculate.calculate("2 @ 1"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 +", "2 / 1 *"})
    @DisplayName("잘못된 입력 값 전달 시 예외")
    public void calculateWithInvalidInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculate.calculate(input));
    }
}
