package com.java.jaeheon.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void setup() {
        this.car = new Car();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveAfterAttempt(int condition) {
        assertThat(car.getDistance() - car.attempt(condition).getDistance()).isEqualTo(-1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopAfterAttempt(int condition) {
        assertThat(car.attempt(condition).getDistance() - car.getDistance()).isEqualTo(0);
    }

}
