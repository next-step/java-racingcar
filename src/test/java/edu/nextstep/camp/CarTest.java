package edu.nextstep.camp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void create() {
        Car car = new Car();
        assertThat(car.position()).isEqualTo(Position.of(0));
    }

    @Test
    public void trip() {
        Car car = new Car();
        assertThat(car.trip()).isEqualTo("");
        car.move();
        assertThat(car.trip()).isEqualTo("-".repeat(1));
        car.move();
        assertThat(car.trip()).isEqualTo("-".repeat(2));
        car.move();
        assertThat(car.trip()).isEqualTo("-".repeat(3));
        car.move();
        assertThat(car.trip()).isEqualTo("-".repeat(4));
    }
}
