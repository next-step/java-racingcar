package com.game.racing.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    void set_up() {
        car = new Car("honux");
    }

    @Test
    void car_move_and_get_position() {
        car.move();
        assertEquals(1, car.getPosition().get());
    }

    @Test
    void car_get_name() {
        assertEquals("honux", car.getName());
    }
}