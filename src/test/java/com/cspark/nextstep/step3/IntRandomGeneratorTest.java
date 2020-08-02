package com.cspark.nextstep.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntRandomGeneratorTest {

    private IntRandomGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new IntRandomGenerator();
    }

    @Test
    void generate() {
        assertThat(generator.generate(0, 9))
                .isBetween(0, 9);
    }
}