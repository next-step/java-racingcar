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
    void add1() {
        final StringCalculateValue value = StringCalculateValue.text("1 + 1");

        int result = value.getValue(0);
        for (int i = 1; i < value.length(); i += 2) {
            result = value.getOperator(i).apply(result, value.getValue(i + 1));
        }
        assertThat(result).isEqualTo(2);
    }

    @Test
    void add2() {
        final StringCalculateValue value = StringCalculateValue.text("2 + 5");

        int result = value.getValue(0);
        for (int i = 1; i < value.length(); i += 2) {
            result = value.getOperator(i).apply(result, value.getValue(i + 1));
        }
        assertThat(result).isEqualTo(7);
    }

    @Test
    void add3() {
        final StringCalculateValue value = StringCalculateValue.text("123 + 123");

        int result = value.getValue(0);
        for (int i = 1; i < value.length(); i += 2) {
            result = value.getOperator(i).apply(result, value.getValue(i + 1));
        }
        assertThat(result).isEqualTo(246);
    }
}
