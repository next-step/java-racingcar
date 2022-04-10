package step_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_공백문자_일때(String nullAndEmptyValue) {
        assertThat(Calculator.splitAndSum(nullAndEmptyValue)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3"})
    void 문자열_더하기(String value) {
        assertThat(Calculator.splitAndSum(value)).isEqualTo(6);
    }

    @Test
    void 음수_예외_처리() {
        assertThatThrownBy(() -> Calculator.splitAndSum("-1,-2;-3")).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}