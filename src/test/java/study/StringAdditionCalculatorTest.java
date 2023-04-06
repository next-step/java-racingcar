package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static study.StringAdditionCalculator.*;

class StringAdditionCalculatorTest {
    @ParameterizedTest(name = "[{index}/2] {displayName}")
    @CsvSource(value = {"'',0", ",0"})
    @DisplayName("빈 문자열이나 null 값을 입력할 경우 0 반환")
    void null_혹은_빈문자(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}/2] {displayName}")
    @CsvSource(value = {"0,0", "100,100"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void 숫자_하나(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}/4] {displayName}")
    @CsvSource(value = {"1,10-11", "1,2,3-6", "1:10-11", "1:2,3-6"}, delimiter = '-')
    @DisplayName("컴마 혹은 콜론 구분자로 분리된 숫자들을 입력할 경우 해당 숫자들의 합 반환")
    void 컴마_혹은_콜론_구분자로_분리된_숫자들(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }
}