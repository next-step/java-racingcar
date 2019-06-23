package com.java.jaeheon.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame;
    int numberOfCars;

    String nameOfCars = "A,B,C";
    int numberOfAttempts = 3;

    @BeforeEach
    void setup() {
        numberOfCars = nameOfCars.split(",").length;
        racingGame = new RacingGame(nameOfCars, numberOfAttempts);
    }

    @Test
    void register() {
        assertThat(racingGame.getNumberOfCars()).isEqualTo(numberOfCars);
    }
}
