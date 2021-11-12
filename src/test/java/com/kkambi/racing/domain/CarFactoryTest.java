package com.kkambi.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @DisplayName("자동차 생성")
    @Test
    void createCar() {
        // when
        Car createdCar = CarFactory.getCar();

        // then
        assertThat(createdCar).isInstanceOf(Car.class);
    }
}