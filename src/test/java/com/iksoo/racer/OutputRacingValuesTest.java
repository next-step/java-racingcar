package com.iksoo.racer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class OutputRacingValuesTest {
    OutputRacingValues output;

    @BeforeEach
    void setUp() {
        output = new OutputRacingValues();
    }

    @Test
    void printLineTest() {
        assertThat(output.printLine(2)).isEqualTo("--");
        assertThat(output.printLine(5)).isEqualTo("-----");
    }
}
