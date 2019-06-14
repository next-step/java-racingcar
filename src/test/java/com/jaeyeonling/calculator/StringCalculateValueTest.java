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
        assertThat(StringCalculateValue.text("1 + 1").calculate()).isEqualTo(2);
        assertThat(StringCalculateValue.text("2 + 5").calculate()).isEqualTo(7);
        assertThat(StringCalculateValue.text("123 + 123").calculate()).isEqualTo(246);
    }

    @Test
    void subtract() {
        assertThat(StringCalculateValue.text("1 - 1").calculate()).isEqualTo(0);
        assertThat(StringCalculateValue.text("10 - 2").calculate()).isEqualTo(8);
        assertThat(StringCalculateValue.text("500 - 2").calculate()).isEqualTo(498);
    }

    @Test
    void multiply() {
        assertThat(StringCalculateValue.text("1 * 1").calculate()).isEqualTo(1);
        assertThat(StringCalculateValue.text("10 * 2").calculate()).isEqualTo(20);
        assertThat(StringCalculateValue.text("500 * 2").calculate()).isEqualTo(1000);
    }

    @Test
    void divide() {
        assertThat(StringCalculateValue.text("1 / 1").calculate()).isEqualTo(1);
        assertThat(StringCalculateValue.text("10 / 2").calculate()).isEqualTo(5);
        assertThat(StringCalculateValue.text("500 / 2").calculate()).isEqualTo(250);
    }

    @Test
    void complexCalculate() {
        assertThat(StringCalculateValue.text("1 + 1 + 1 + 123").calculate()).isEqualTo(126);
        assertThat(StringCalculateValue.text("1 - 1 + 1 * 100").calculate()).isEqualTo(100);
        assertThat(StringCalculateValue.text("1 * 2 * 3 * 4 * 5").calculate()).isEqualTo(120);
        assertThat(StringCalculateValue.text("100 / 2 * 2 + 100 - 50").calculate()).isEqualTo(150);
    }

}
