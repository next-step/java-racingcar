package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomGenerator;

class CarTest {

    @Test
    void move() {
        Car car = new Car();
        RandomGenerator randomGenerator = new RandomGenerator() {
            public boolean isMovable() {
                return true;
            }
        };
        car.move();
        assertThat(car.getLocation()).isEqualTo(2);
    }

    @Test
    void stop() {
        Car car = new Car();
        RandomGenerator randomGenerator = new RandomGenerator() {
            public boolean isMovable() {
                return false;
            }
        };
        car.move();
        assertThat(car.getLocation()).isEqualTo(1);
    }
}