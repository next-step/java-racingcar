package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static final int ZERO = 0;
    private static final int FOUR = 4;

    @Test
    @DisplayName("[요구사항 1] random 값이 4 이상일 경우 1칸 전진한다.")
    void 요구사항_1() {
        // given
        Car car = new Car();
        final int CAR_MOVE_COUNT = car.getMoveCount();

        // when
        car.move(FOUR);

        // then
        assertThat(car.getMoveCount()).isEqualTo(CAR_MOVE_COUNT + 1);
    }

    @Test
    @DisplayName("[요구사항 2] random 값이 4 미만일 경우 멈춘다.")
    void 요구사항_2() {
        // given
        Car car = new Car();
        final int CAR_MOVE_COUNT = car.getMoveCount();

        // when
        car.move(ZERO);

        // then
        assertThat(car.getMoveCount()).isEqualTo(CAR_MOVE_COUNT);
    }
}
