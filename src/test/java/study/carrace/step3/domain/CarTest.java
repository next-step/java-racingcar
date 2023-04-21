package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void move() {
        // given
        Car car = new Car("test", mockMoveStrategy(true));

        // when
        car.moveOrStop();

        // then
        assertThat(car.positionAt(1)).isEqualTo("test : -");
    }

    @Test
    void stop() {
        // given
        Car car = new Car("test", mockMoveStrategy(false));

        // when
        car.moveOrStop();

        // then
        assertThat(car.positionAt(1)).isEqualTo("test : ");
    }

    @ParameterizedTest(name = "[{index}/2] 자동차 이동 횟수 반환")
    @CsvSource(value = {"false,0", "true,2"})
    void number_of_move(boolean movable, long expected) {
        // given
        Car car = new Car("test", mockMoveStrategy(movable));
        car.moveOrStop();
        car.moveOrStop();

        // when, then
        assertThat(car.numberOfMove()).isEqualTo(expected);
    }

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}