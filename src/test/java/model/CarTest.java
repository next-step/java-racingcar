package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void shouldMove() {
        CarPosition originPosition = new CarPosition(0);
        Car testCar = Car.carWithNameAndPosition(new CarName("test"), originPosition);

        testCar.move();

        assertThat(testCar.getCarPosition().compareTo(originPosition)).isPositive();
    }

    @Test
    void shouldNotMove() {
        CarPosition originPosition = new CarPosition(0);
        Car testCar = Car.carWithNameAndPosition(new CarName("test"), originPosition);

        assertThat(testCar.getCarPosition()).isEqualTo(originPosition);
    }
}
