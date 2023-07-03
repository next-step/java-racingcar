package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void carTest_isMove() {
        Car car = new Car("hello", 1, new Random());
        assertThat(car.isMove(4)).isTrue();
        assertThat(car.isMove(3)).isFalse();
    }

    @Test
    void carTest_move() {
        Car car = new Car("hello", 1, new MockRandom(4));
        car.move();
        assertThat(car.getIndex()).isEqualTo(2);

        Car car2 = new Car("hello", 1, new MockRandom(3));
        car2.move();
        assertThat(car2.getIndex()).isEqualTo(1);
    }
}
