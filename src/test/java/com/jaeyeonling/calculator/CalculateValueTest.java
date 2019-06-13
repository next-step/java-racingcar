package com.jaeyeonling.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculateValueTest {

    @Test
    void createCalculateValue() {
        assertThat(CalculateValue.text("1 + 1")).isNotNull();
    }
}
