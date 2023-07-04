package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private final int canMoveValue = 4;
    private final int canNotMoveValue = 3;

    @Test
    void carTest_isMove() {
        Car car = new Car("hello");
        assertThat(car.isMove(canMoveValue)).isTrue();
        assertThat(car.isMove(canNotMoveValue)).isFalse();
    }

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
