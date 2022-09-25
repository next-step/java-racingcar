package com.game.racing.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @Test
    public void car_move() {
        car = new Car();
        Assertions.assertEquals(2, car.move());
    }

    @Test
    public void car_moveAndPrintCurrentPosition() {
        car = new Car();
        car.move();
        Assertions.assertEquals("--", car.printCurrentPosition());
    }
}