package com.jaeyeonling.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("Car 객체 생성")
    @Test
    void createCar() {
        assertThat(new Car()).isNotNull();
    }
}
