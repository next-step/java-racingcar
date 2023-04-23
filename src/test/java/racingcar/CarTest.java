package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("[요구사항 1] random 값이 4 이상일 경우(전진 조건 만족할 경우) 1칸 전진한다.")
    void 요구사항_1() {
        // given
        final int CAR_MOVE_COUNT = car.getMoveCount();

        // when
        car.move(()->true);

        // then
        assertThat(car.getMoveCount()).isEqualTo(CAR_MOVE_COUNT + 1);
    }

    @Test
    @DisplayName("[요구사항 2] random 값이 4 미만일 경우 멈춘다.")
    void 요구사항_2() {
        // given
        final int CAR_MOVE_COUNT = car.getMoveCount();

        // when
        car.move(()->false);

        // then
        assertThat(car.getMoveCount()).isEqualTo(CAR_MOVE_COUNT);
    }
}
