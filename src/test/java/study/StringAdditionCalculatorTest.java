package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class StringAdditionCalculatorTest {
    @ParameterizedTest(name = "[{index}/3] {displayName}")
    @CsvSource(value = {"'',0", ",0", "' ',0"})
    @DisplayName("빈 문자열이나 null 값을 입력할 경우 0 반환")
    void 빈_문자열_또는_null_덧셈_연산(String input, int expected) {
        // given, when
        int result = StringAdditionCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}