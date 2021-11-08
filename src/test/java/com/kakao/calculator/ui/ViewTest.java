package com.kakao.calculator.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ViewTest {

    @Test
    @DisplayName("입력테스트")
    void inputExpression() {
        String inputExpression = "1 + 3";
        String expression = View.inputExpression(new ByteArrayInputStream(inputExpression.getBytes()));
        assertThat(expression).isEqualTo(inputExpression);
    }
}
