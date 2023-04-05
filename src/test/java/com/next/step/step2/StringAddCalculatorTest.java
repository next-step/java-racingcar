package com.next.step.step2;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest(name = "입력이 NULL 또는 빈 문자열인 경우")
    @NullSource
    @ValueSource(strings = "")
    public void splitAndSum_null_empty_input(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest(name = "입력이 숫자 하나인 경우")
    @CsvSource(value = {"1|1", "2|2", "3|3"}, delimiter = '|')
    public void splitAndSum_a_number_input(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력에 쉼표 구분자가 포함된 경우")
    @CsvSource(value = {"1,2|3", "2,3|5", "3,4|7"}, delimiter = '|')
    public void splitAndSum_with_comma_input(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력에 쉼표와 콜론 구분자가 혼합하여 포함된 경우")
    @CsvSource(value = {"1,2:3|6", "2:3,4|9"}, delimiter = '|')
    public void splitAndSum_with_comma_colon_input(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력에 커스텀 구분자가 포함된 경우")
    public void splitAndSum_custom_delimiter_input() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest(name = "입력에 음수가 포함된 경우")
    @ValueSource(strings = {"-1,2,3","-1:2:3","-100,-200,-300"})
    public void splitAndSum_negative_input(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}
