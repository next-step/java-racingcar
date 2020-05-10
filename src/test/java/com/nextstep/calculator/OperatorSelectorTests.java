package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorSelectorTests {
    @DisplayName("문자열로 사칙연산 입력 시 알맞는 Operator 타입 반환")
    @ParameterizedTest
    @CsvSource(value = {"+=PLUS", "-=MINUS", "*=MULTIPLY", "/=DIVIDE"}, delimiter = '=')
    void selectorTest(String stringValue, String operatorName) {
        Operator operator = OperatorSelector.select(stringValue);

        assertThat(operator.name()).isEqualTo(operatorName);
    }

    @DisplayName("사칙 연산으로 변환 불가능한 String 입력 시 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"hello", " ", "no"})
    void selectorTestWithInvalidInputs(String invalidInput) {
        assertThatThrownBy(() -> OperatorSelector.select(invalidInput)).isInstanceOf(IllegalArgumentException.class);
    }
}
