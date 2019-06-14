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
}
