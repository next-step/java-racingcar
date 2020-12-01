package com.nextstep.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {
    @DisplayName("문자열을 인자로 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Number one = new Number("1");
        
        assertThat(one).isNotNull();
    }
}