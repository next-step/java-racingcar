package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    Car car = new Car("Dami");

    @Test
    void 랜덤_값이_4이상일_경우_전진하는_테스트() {
        final int DISTANCE = 5;
        final int RESULT = 5;

        car.move(DISTANCE);

        int position = car.getPosition();

        assertThat(position).isEqualTo(RESULT);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤_값이_4이상일_경우_전진하는_상태를_만드는_테스트(int distance) {
        assertTrue(car.isMovable(distance));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤_값이_4미만일_경우_전진하지_않는_상태를_만드는_테스트(int distance) {
        assertFalse(car.isMovable(distance));
    }


}