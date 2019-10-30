package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.Car;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차가 전진한다.")
    @Test
    void move() {
        Car car = new Car() {
            public int createRandom() {
              return 4;
            }
        };
        assertThat(car.move()).isTrue();
    }

    @DisplayName("자동차가 멈춘다.")
    @Test
    void stop() {
        Car car = new Car() {
            public int createRandom() {
                return 3;
            }
        };
        assertThat(car.move()).isFalse();
    }

}
