package main.java.racingCar.controller;

import main.java.racingCar.model.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void testCar(){
        Car car = new Car();
        car.move();
        assertThat(car.getPosition()).isBetween(0,1);
    }
}
