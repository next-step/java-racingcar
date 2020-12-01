package com.nextstep.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    @DisplayName("사칙연산 문자열을 인자로 전달해 원하는 사칙연산 객체를 찾을 수 있다.")
    @Test
    void createTest() {
        String operator = "+";

        assertThat(Operator.of(operator)).isEqualTo(Operator.PLUS);
    }
}