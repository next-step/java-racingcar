package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void testCarInitialPosition() {
        Car car = new Car();
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void testCarMoveCase() {
        Car car = new Car();
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void testCarUnMoveCase() {
        Car car = new Car();
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
