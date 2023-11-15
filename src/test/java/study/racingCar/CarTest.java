package study.racingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @Test
    void carPositionTest() {
        Car car = new Car();
        Position p = car.currentPosition();
        assertThat(p.position()).isEqualTo(0);
    }

    @Test
    void carPositionIncreaseTest() {
        Car car = new Car();
        Position p = car.currentPosition();
        p = p.increase(4);
        p = p.increase(5);
        assertThat(p.position()).isEqualTo(2);
    }
}