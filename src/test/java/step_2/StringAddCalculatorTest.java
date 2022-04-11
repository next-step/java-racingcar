package step_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3", "//:\n1:2:3", "//,\n1,2,3"})
    void 구분자_기준_문자열_자르기(String value) {
        assertThat(Splitter.split().apply(value)).hasSize(3);
    }

    @Test
    void 문자열_배열_숫자형으로_컨버팅() {
        assertThat(NumberConverter.toInts().apply(List.of("1", "2", "3"))).isNotEmpty().hasSize(3);
    }

    @Test
    void 컨버터_객체의_음수_예외_처리() {
        assertThatThrownBy(() -> NumberConverter.toInts().apply(List.of("-1", "-2", "-3"))).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_공백문자_일때(String nullAndEmptyValue) {
        assertThat(Calculator.splitAndSum(nullAndEmptyValue)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3", "//:\n1:2:3", "//,\n1,2,3"})
    void 문자열_더하기(String value) {
        assertThat(Calculator.splitAndSum(value)).isEqualTo(6);
    }

    @Test
    void 계산기_및_컨버터_객체의_음수_예외_처리() {
        assertThatThrownBy(() -> Calculator.splitAndSum("-1,-2:-3")).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}