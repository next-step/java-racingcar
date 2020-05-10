package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTests {
    @DisplayName("Operator PLUS로 Number객체 두개의 덧셈을 수행")
    @Test
    void plusOperatorTest() {
        Number one = Number.stringToNumber("1");
        Operator plus = Operator.PLUS;

        assertThat(plus.operate(one, one)).isEqualTo(Number.stringToNumber("2"));
    }
}
