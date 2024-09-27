import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {
    @ParameterizedTest
    @EmptySource
    @NullSource
    @DisplayName("빈 문자열 또는 null이면 0을 반환")
    void whenGivenNullOrEmpty(String input) {
        int result = StringAddCalculator.emptyOrNull(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환한다")
    void inputOneNumberStringReturnToInteger() {
        int result = StringAddCalculator.processOneNumberString("1");

        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    void splitAndSumWithComma(String input) {
        int result = StringAddCalculator.splitAndSumWithComma(input);

        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    @DisplayName("구분자를 컴마 이외에 콜론을 사용할 수 있다")
    void splitAndSumWithCommaOrColon(String input) {
        int result = StringAddCalculator.splitAndSumWithCommaOrColon(input);

        assertThat(result).isEqualTo(6);
    }
}
