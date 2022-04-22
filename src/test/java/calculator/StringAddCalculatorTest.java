package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringAddCalculatorTest {

    Splitter splitter;
    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        splitter = new Splitter();
        calculator = new Calculator(splitter);
    }

    @Test
    @DisplayName("Number 객체 생성")
    void createNumberInstance() {
        assertThat(new Numbers.Number("1")).isInstanceOf(Numbers.Number.class);
    }

    @Test
    @DisplayName("Number 객체 생성 시, 음수 예외 처리")
    void numberThrowNegativeArg() {
        assertThatThrownBy(() -> new Numbers.Number("-1")).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Numbers 객체 생성")
    void createNumbersInstance() {
        List<String> args = List.of("1", "2", "3");
        assertAll(() -> assertThat(new Numbers(args)).isInstanceOf(Numbers.class),
                () -> assertThat(new Numbers(args).size()).isEqualTo(3));
    }

    @Test
    @DisplayName("Numbers 객체 생성 시 음수에 대한 예외 처리")
    void numbersThrowNegativeArgs() {
        assertThatThrownBy(() -> new Numbers(List.of("-1", "-2", "-3"))).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "구분자 기준 문자열 자르기 - {0}")
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3", "//:\n1:2:3", "//,\n1,2,3"})
    void splitString(String value) {
        assertThat(splitter.split().apply(value)).hasSize(3);
    }

    @ParameterizedTest(name = "빈 문자열 공백문자 - {0}")
    @NullAndEmptySource
    void setNullAndEmptyValue(String nullAndEmptyValue) {
        assertThat(calculator.sum(nullAndEmptyValue)).isEqualTo(0);
    }

    @ParameterizedTest(name = "문자열 더하기 - {0}")
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3", "//:\n1:2:3", "//,\n1,2,3"})
    void sumString(String value) {
        assertThat(calculator.sum(value)).isEqualTo(6);
    }

    @Test
    @DisplayName("계산기 더하기 명령 수행 시, 음수에 대한 예외 처리")
    void calculatorThrowNegativeArgs() {
        assertThatThrownBy(() -> calculator.sum("-1,-2:-3")).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}