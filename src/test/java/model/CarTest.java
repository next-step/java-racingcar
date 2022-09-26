package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void shouldMove() {
        Car testCar = Car.carWithName(new CarName("test"));
        CarPosition originPosition = testCar.getCarPosition();

        testCar.move();

        assertThat(testCar.getCarPosition().compareTo(originPosition)).isPositive();
    }

    @Test
    void shouldNotMove() {
        Car testCar = Car.carWithName(new CarName("test"));

        assertThat(testCar.getCarPosition()).isEqualTo(testCar.getCarPosition());
    }
}
