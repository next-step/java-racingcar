package com.cspark.nextstep.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiceTest {

    private final int MIN = 0;
    private final int MAX = 9;
    private Dice generator;

    @BeforeEach
    void setUp() {
        this.generator = new Dice(MIN, MAX);
    }

    @DisplayName("0-9 랜덤생성기")
    @Test
    void cast() {
        assertThat(generator.cast())
                .isBetween(MIN, MAX);
    }
}