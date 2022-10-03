package com.game.racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    private final String carName = "honux";

    @Test
    void car_move() {
        Car car = new Car(carName);
        car.move();
        assertThat(car.getPosition().get()).isEqualTo(1);
    }

}