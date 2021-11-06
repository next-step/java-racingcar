package edu.nextstep.camp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void create() {
        Car car = new Car();
        assertThat(car.position()).isEqualTo(0);
    }

    @Test
    public void move() {
        Car car = new Car();
        assertThat(car.position()).isEqualTo(0);
        car.move();
        assertThat(car.position()).isEqualTo(1);
        car.move();
        assertThat(car.position()).isEqualTo(2);
        car.move();
        assertThat(car.position()).isEqualTo(3);
        car.move();
        assertThat(car.position()).isEqualTo(4);
    }
}
