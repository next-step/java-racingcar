package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class StringAdditionCalculatorTest {
    @ParameterizedTest(name = "[{index}/2] {displayName}")
    @CsvSource(value = {"'',0", ",0"})
    @DisplayName("빈 문자열이나 null 값을 입력할 경우 0 반환")
    void null_or_빈문자(String input, int expected) {
        // given, when
        int result = StringAdditionCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}/2] {displayName}")
    @CsvSource(value = {"0,0", "100,100"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void 숫자_하나(String input, int expected) {
        // given, when
        int result = StringAdditionCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}