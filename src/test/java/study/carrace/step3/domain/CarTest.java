package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void move() {
        // given
        Car car = new Car(mockMoveStrategy(true));

        // when
        car.moveOrStop();

        // then
        assertThat(car.getMoveStatus()).containsExactly(true);
    }

    @Test
    void stop() {
        // given
        Car car = new Car(mockMoveStrategy(false));

        // when
        car.moveOrStop();

        // then
        assertThat(car.getMoveStatus()).containsExactly(false);
    }

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}