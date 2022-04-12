package step_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    Calculator calculator;
    Splitter splitter;
    NumberConverter numberConverter;

    @BeforeEach
    void beforeEach() {
        splitter = new Splitter();
        numberConverter = new NumberConverter();
        calculator = new Calculator(splitter, numberConverter);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3", "//:\n1:2:3", "//,\n1,2,3"})
    void 구분자_기준_문자열_자르기(String value) {
        assertThat(splitter.split().apply(value)).hasSize(3);
    }

    @Test
    void 문자열_배열_숫자형으로_컨버팅() {
        assertThat(numberConverter.toInts().apply(List.of("1", "2", "3"))).isNotEmpty().hasSize(3);
    }

    @Test
    void 컨버터_객체의_음수_예외_처리() {
        assertThatThrownBy(() -> numberConverter.toInts().apply(List.of("-1", "-2", "-3"))).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_공백문자_일때(String nullAndEmptyValue) {
        assertThat(calculator.splitAndSum(nullAndEmptyValue)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3", "//:\n1:2:3", "//,\n1,2,3"})
    void 문자열_더하기(String value) {
        assertThat(calculator.splitAndSum(value)).isEqualTo(6);
    }

    @Test
    void 계산기_및_컨버터_객체의_음수_예외_처리() {
        assertThatThrownBy(() -> calculator.splitAndSum("-1,-2:-3")).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}