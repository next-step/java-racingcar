package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차는 움직일 수 있다.")
    void move() {
        Car car = new Car();

        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 움직이지 않을 수 있다.")
    void tryMove() {
        Car car = new Car();

        car.move(() -> false);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}