package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차가 생성된다")
    @Test
    void createCar() {
        Car car = new Car();
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차가 이동한다")
    @Test
    void moveCar() {
        Car car = new Car();
        car.move();
        assertThat(car.position()).isOne();
    }
}
