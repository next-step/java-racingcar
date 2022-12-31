package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import caculator.PositiveNumber;
import caculator.StringAddCalculator;

class StringAddCalculatorTest {

    @Test
    @DisplayName("문자열을 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    public void test_add() {
        assertThat(StringAddCalculator.add("//;\n1;2;3")).isEqualTo(6L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "string"})
    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외가 발생한다.")
    public void test_invalid_number(final String given) {
        assertThatThrownBy(() -> new PositiveNumber(given)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("문자열 계산기에 빈 문자열이나 null 을 전달하는 경우 0을 리턴한다.")
    public void test_null_or_zero(final String given) {
        assertThat(new PositiveNumber(given).getValue()).isEqualTo(0);
    }

}