package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void carTest_isMove() {
        Car car = new Car("hello");
        assertThat(car.isMove(4)).isTrue();
        assertThat(car.isMove(3)).isFalse();
    }

    @Test
    void carTest_move() {
        Car car = new Car("hello", new MockRandom(4));
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void carTest_not_move() {
        Car car = new Car("hello", new MockRandom(3));
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
