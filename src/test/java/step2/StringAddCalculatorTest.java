package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우, 0을 반환한다.")
    @EmptySource
    @NullSource
    void nullOrEmptyStringTest(String text) {
        Assertions.assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(0);
    }
}
