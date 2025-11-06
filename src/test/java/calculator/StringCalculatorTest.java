package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringCalculatorTest {

    @DisplayName("빈 문자열 또는 null 입력 시 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNullStringReturnsZero(String input) {
        assertThat(StringCalculator.splitAndSum(input)).isZero();
    }
}