package racingcar.car;

import org.junit.jupiter.api.Test;
import racingcar.MockRandom;
import racingcar.car.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private final int canMoveValue = 4;
    private final int canNotMoveValue = 3;

    @Test
    void carTest_move() {
        Car car = new Car("hello", new MockRandom(canMoveValue));
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void carTest_not_move() {
        Car car = new Car("hello", new MockRandom(canNotMoveValue));
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
