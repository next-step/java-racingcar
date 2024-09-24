package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력하는 경우 0을 반환한다.")
    void test01(final String text) {
        // when
        final var result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void test02(final String text, final int expected) {
        // when
        final var result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName(",을 기준으로 분리한 숫자문자열들의 합을 반환한다.")
    void test03() {
        // given
        final var text = "1,2";

        // when
        final var result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName(",과 :을 기준으로 분리한 숫자문자열들의 합을 반환한다.")
    void test04() {
        // given
        final var text = "1,2:3";

        // when
        final var result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("\"//과 \\n 사이에 위치하는 문자열을 구분자로 지정하여 구분자 기준으로 분리한 숫자문자열들의 합을 반환한다.")
    void test05() {
        // given
        final var text = "//;\n1;2;3";

        // when
        final var result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 포함한 문자열을 입력했을 때 예외가 발생한다.")
    void test06() {
        // given
        final var text = "-1,2,3";

        // when & then
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }

}
