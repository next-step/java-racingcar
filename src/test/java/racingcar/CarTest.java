package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void test() {
        Car car = new Car();
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

}