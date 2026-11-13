package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSumCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열 입력시 0을 반환")
    void nullOrEmpty(String input) {
        final int result = StringSumCalculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"1,1","5,5","123,123"})
    @DisplayName("하나의 숫자만 입력된 경우 해당 수를 반환한다.")
    void singleNumericInput(String input, int expected) {
        final int result = StringSumCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자의 합을 반환한다")
    void commaSeparator() {
        final int result = StringSumCalculator.calculate("1,2,3");

        assertThat(result).isEqualTo(6);
    }
}
