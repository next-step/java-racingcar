package com.jaeyeonling.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculateValueTest {

    @Test
    @DisplayName("StringCalculateValue 생성")
    void createCalculateValue() {
        assertThat(StringCalculateValue.ofExpression("1 + 1")).isNotNull();
    }

    @Test
    @DisplayName("잘못된 계산식 입력 시 예외처리")
    void invalidExpression() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.ofExpression(null);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.ofExpression("");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.ofExpression("123");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.ofExpression("123 &");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.ofExpression("123 &");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.ofExpression("123 ^ 23423");
                });
    }

    @Test
    @DisplayName("더하기")
    void add() {
        assertThat(StringCalculateValue.ofExpression("1 + 1").getResult()).isEqualTo(2);
        assertThat(StringCalculateValue.ofExpression("2 + 5").getResult()).isEqualTo(7);
        assertThat(StringCalculateValue.ofExpression("123 + 123").getResult()).isEqualTo(246);
    }

    @Test
    @DisplayName("빼기")
    void subtract() {
        assertThat(StringCalculateValue.ofExpression("1 - 1").getResult()).isEqualTo(0);
        assertThat(StringCalculateValue.ofExpression("10 - 2").getResult()).isEqualTo(8);
        assertThat(StringCalculateValue.ofExpression("500 - 2").getResult()).isEqualTo(498);
    }

    @Test
    @DisplayName("곱하기")
    void multiply() {
        assertThat(StringCalculateValue.ofExpression("1 * 1").getResult()).isEqualTo(1);
        assertThat(StringCalculateValue.ofExpression("10 * 2").getResult()).isEqualTo(20);
        assertThat(StringCalculateValue.ofExpression("500 * 2").getResult()).isEqualTo(1000);
    }

    @Test
    @DisplayName("나누기")
    void divide() {
        assertThat(StringCalculateValue.ofExpression("1 / 1").getResult()).isEqualTo(1);
        assertThat(StringCalculateValue.ofExpression("10 / 2").getResult()).isEqualTo(5);
        assertThat(StringCalculateValue.ofExpression("500 / 2").getResult()).isEqualTo(250);
    }

    @Test
    @DisplayName("복합적인 계산")
    void complexCalculate() {
        assertThat(StringCalculateValue.ofExpression("1 + 1 + 1 + 123").getResult()).isEqualTo(126);
        assertThat(StringCalculateValue.ofExpression("1 - 1 + 1 * 100").getResult()).isEqualTo(100);
        assertThat(StringCalculateValue.ofExpression("1 * 2 * 3 * 4 * 5").getResult()).isEqualTo(120);
        assertThat(StringCalculateValue.ofExpression("100 / 2 * 2 + 100 - 50").getResult()).isEqualTo(150);
    }

}
