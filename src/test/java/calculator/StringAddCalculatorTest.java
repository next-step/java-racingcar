package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void test02(final String text) {
        // when
        final var result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(Integer.parseInt(text));
    }

    @Test
    @DisplayName("\"1,2\" 문자열을 입력했을 때 3을 반환한다.")
    void test03() {
        // given
        final var text = "1,2";

        // when
        final var result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("\"1,2:3\" 문자열을 입력했을 때 6을 반환한다.")
    void test04() {
        // given
        final var text = "1,2:3";

        // when
        final var result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("\"//;\n1;2;3\" 문자열을 입력했을 때 6을 반환한다.")
    void test05() {
        // given
        final var text = "//;\n1;2;3";

        // when
        final var result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("\"-1,2,3\" 문자열을 입력했을 때 예외가 발생한다.")
    void test06() {
        // given
        final var text = "-1,2,3";

        // when & then
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }

}
