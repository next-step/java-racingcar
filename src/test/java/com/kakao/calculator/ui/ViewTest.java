package com.kakao.calculator.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ViewTest {

    @Test
    @DisplayName("입력테스트")
    void inputExpression() {
        String inputExpression = "1 + 3";
        String expression = View.inputExpression(new ByteArrayInputStream(inputExpression.getBytes()));
        assertThat(expression).isEqualTo(inputExpression);
    }
}
