package calculator;

import exception.NumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void null_또는_space(String input) {
        assertThat(splitAndSum(input)).isZero();
    }

    @Test
    void 문자열_하나() {
        assertThat(splitAndSum("1")).isOne();
    }

    @Test
    void 문자열_쉼표_구분자() {
        assertThat(splitAndSum("1,2,3")).isEqualTo(6);
    }

    @Test
    void 문자열_쉼표_콜론_구분자() {
        assertThat(splitAndSum("1,2;3")).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//:\n1:2:3"})
    void 커스텀_구분자(String input) {
        assertThat(splitAndSum(input)).isEqualTo(6);
    }

    @Test
    void 숫자_음수() {
        assertThatThrownBy(() -> splitAndSum("1,2;-3")).isInstanceOf(NumberException.class);
    }
}
