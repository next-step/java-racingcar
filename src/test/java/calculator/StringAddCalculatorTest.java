package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @DisplayName("null 또는 빈 문자열 입력 시 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void returnsZeroOnNullOrEmpty(String text) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(0);
    }

    @DisplayName("하나의 숫자만 입력될 경우 해당 숫자를 반환해야 한다.")
    @Test
    void returnsItselfOnSingleNumber() {
        assertThat(StringAddCalculator.splitAndSum("10")).isEqualTo(10);
    }

    @DisplayName("쉼표(,) 또는 콜론(:) 구분자를 사용해 합계를 계산해야 한다.")
    @Test
    void sumWithCommaOrColon() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자를 사용하여 합계를 계산해야 한다.")
    @Test
    void sumWithCustomDelimiter() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("음수가 포함된 경우 RuntimeException이 발생해야 한다.")
    @Test
    void throwsExceptionOnNegativeNumber() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,-2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수를 입력할 수 없습니다.");
    }
}