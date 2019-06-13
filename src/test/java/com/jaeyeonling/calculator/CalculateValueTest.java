package com.jaeyeonling.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculateValueTest {

    @Test
    void createCalculateValue() {
        assertThat(CalculateValue.text("1 + 1")).isNotNull();
    }

    @Test
    void invalidText() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CalculateValue.text(null);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CalculateValue.text("");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CalculateValue.text("123");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CalculateValue.text("123 &");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CalculateValue.text("123 &");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CalculateValue.text("123 ^ 23423");
                });
    }
}
