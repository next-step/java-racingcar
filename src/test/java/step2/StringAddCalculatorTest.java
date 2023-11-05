package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우, 0을 반환한다.")
    @EmptySource
    @NullSource
    void nullOrEmptyStringTest(String text) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("숫자 하나를 문자열로 입력할 경우, 해당 숫자를 반환한다.")
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void singleNumberTest(String text, int expected) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(expected);
    }
}
