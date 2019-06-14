package com.jaeyeonling.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculateValueTest {

    @Test
    void createCalculateValue() {
        assertThat(StringCalculateValue.text("1 + 1")).isNotNull();
    }

    @Test
    void invalidText() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.text(null);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.text("");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.text("123");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.text("123 &");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.text("123 &");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculateValue.text("123 ^ 23423");
                });
    }

    @Test
    void add() {
        assertThat(StringCalculateValue.text("1 + 1").getResult()).isEqualTo(2);
        assertThat(StringCalculateValue.text("2 + 5").getResult()).isEqualTo(7);
        assertThat(StringCalculateValue.text("123 + 123").getResult()).isEqualTo(246);
    }

    @Test
    void subtract() {
        assertThat(StringCalculateValue.text("1 - 1").getResult()).isEqualTo(0);
        assertThat(StringCalculateValue.text("10 - 2").getResult()).isEqualTo(8);
        assertThat(StringCalculateValue.text("500 - 2").getResult()).isEqualTo(498);
    }

    @Test
    void multiply() {
        assertThat(StringCalculateValue.text("1 * 1").getResult()).isEqualTo(1);
        assertThat(StringCalculateValue.text("10 * 2").getResult()).isEqualTo(20);
        assertThat(StringCalculateValue.text("500 * 2").getResult()).isEqualTo(1000);
    }

    @Test
    void divide() {
        assertThat(StringCalculateValue.text("1 / 1").getResult()).isEqualTo(1);
        assertThat(StringCalculateValue.text("10 / 2").getResult()).isEqualTo(5);
        assertThat(StringCalculateValue.text("500 / 2").getResult()).isEqualTo(250);
    }

    @Test
    void complexCalculate() {
        assertThat(StringCalculateValue.text("1 + 1 + 1 + 123").getResult()).isEqualTo(126);
        assertThat(StringCalculateValue.text("1 - 1 + 1 * 100").getResult()).isEqualTo(100);
        assertThat(StringCalculateValue.text("1 * 2 * 3 * 4 * 5").getResult()).isEqualTo(120);
        assertThat(StringCalculateValue.text("100 / 2 * 2 + 100 - 50").getResult()).isEqualTo(150);
    }

}
