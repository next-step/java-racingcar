package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @Test
    @DisplayName("splitAndSum 메서드에 null을 넣으면 0을 반환한다.")
    void splitAndSum_Null_Zero() {
        final int result = StringAddCalculator.splitAndSum(null);

        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    @DisplayName("splitAndSum 메서드에 빈 문자열, 공백, 개행을 넣으면 0을 반환한다.")
    void splitAndSum_Blank_Zero(final String blank) {
        final int result = StringAddCalculator.splitAndSum(blank);

        assertThat(result).isZero();
    }
}
