package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void carAdeTest() {
        Car car = new Car();

        car.move();
        car.move();

        assertThat(car.getPosition()).isEqualTo(2);
    }
}