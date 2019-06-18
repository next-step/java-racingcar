package com.java.jaeheon.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    CarManagement carManagement;
    int numberOfAttempts;
    CarRacing carRacing;

    @BeforeEach
    void setup() {
        carManagement = new CarManagement();
        numberOfAttempts = 5;
        carRacing = new CarRacing(carManagement, numberOfAttempts);
    }

    @Test
    void numberOfRacingAttemptsByCar() {
        carRacing.carRacingStart();
        for (Car car : carManagement.Cars()) {
            assertThat(car.getNumberOfAttempts()).isEqualTo(numberOfAttempts);
        }
    }

}
