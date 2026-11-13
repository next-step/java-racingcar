package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSumCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열 입력시 0을 반환")
    void nullOrEmpty (String input) {
        final int result = StringSumCalculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }
}
