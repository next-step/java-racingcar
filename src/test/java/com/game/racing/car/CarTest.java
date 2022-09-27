package com.game.racing.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @Test
    void car_move() {
        car = new Car();
        Assertions.assertEquals(2, car.move());
    }

    @Test
    void car_get_position() {
        car = new Car();
        Assertions.assertEquals(1, car.getPosition());
    }
}