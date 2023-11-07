package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.race.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("자동차가 이동하면 이동거리가 1 증가 한다")
    void move_car() {
        Car car = new Car();
        car.move();
        assertThat(car.distance()).isEqualTo(1);
    }
}