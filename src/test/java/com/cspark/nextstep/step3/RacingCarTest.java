package com.cspark.nextstep.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @DisplayName("반복 전진/정지")
    @Test
    void race() {
        assertThat(racingCar.race(true))
                .as("1전진")
                .isEqualTo(1);

        assertThat(racingCar.race(false))
                .as("1전진 1정지")
                .isEqualTo(1);

        assertThat(racingCar.race(true))
                .as("1전진 1정지")
                .isEqualTo(2);
    }
}