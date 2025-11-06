package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @DisplayName("빈 문자열 또는 null 입력 시 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyOrNullStringReturnsZero(String input) {
        assertThat(StringCalculator.splitAndSum(input)).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력 시 해당 숫자를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10"})
    void singleNumberStringReturnsSameNumber(String input) {
        assertThat(StringCalculator.splitAndSum(input)).isEqualTo(Integer.parseInt(input));
    }

}