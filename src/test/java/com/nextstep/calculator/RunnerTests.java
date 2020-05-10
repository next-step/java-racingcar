package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RunnerTests {
    @DisplayName("단항 사칙연산 계산하기")
    @ParameterizedTest
    @CsvSource(value = { "2 + 3:5", "2 - 3:-1", "2 * 3:6", "2 / 3:0" }, delimiter = ':')
    void calculatorTest(String input, int result) {
        int number = Runner.run(input);

        assertThat(number).isEqualTo(result);
    }

    @DisplayName("사칙연산이 아닌 연산자 입력 시 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = { "2 f 3", "2 2 3", "2 호 3", "2 하 3" })
    void calculatorTestWithInvalidOperator(String invalidOperator) {
        assertThatThrownBy(() -> Runner.run(invalidOperator)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("여러항 사칙연산 계산하기")
    @ParameterizedTest
    @CsvSource(value = { "2 + 3 - 1:4", "3 + 5 - 2 / 3 * 2:4", "2 + 3 * 4 / 2:10" }, delimiter = ':')
    void calculateMulti(String input, int result) {
        int number = Runner.run(input);

        assertThat(number).isEqualTo(result);
    }
}
