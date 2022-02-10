package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    Car car = new Car("Dami");

    @Test
    void 랜덤_값이_4이상일_경우_전진한다() {
        final int DISTANCE = 5;
        final int RESULT = 5;

        car.move(DISTANCE);

        int position = car.getPosition();

        assertThat(position).isEqualTo(RESULT);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤_값이_4이상일_경우_전진하는_상태를_만든다(int distance) {
        assertTrue(car.isMovable(distance));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤_값이_4미만일_경우_전진하지_않는_상태를_만든다(int distance) {
        assertFalse(car.isMovable(distance));
    }

    @Test
    void 우승여부를_판별한다() {
        final int DISTANCE = 5;
        Car car = new Car("Dami");

        car.move(DISTANCE);

        assertTrue(car.isWinner(DISTANCE));
    }

    @Test
    void 최대_전진_거리보다_멀리_전진했는지_판별한다() {
        final int DISTANCE = 7;
        final int MAX_DISTANCE = 5;
        Car car = new Car("Dami");

        car.move(DISTANCE);

        assertTrue(car.isFartherThan(MAX_DISTANCE));
    }
}