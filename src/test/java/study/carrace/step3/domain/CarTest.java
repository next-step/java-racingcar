package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.List;

import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void move() {
        // given
        MoveStrategy mockMoveStrategy = mockMoveStrategy(true);
        String carName = "test";

        // when
        Car car = new Car(carName, mockMoveStrategy).moveOrStop(1);

        // then
        Car expectedCar = new Car(carName, mockMoveStrategy, new CarPosition(List.of(true)));
        assertThat(car).isEqualTo(expectedCar);
    }

    @Test
    void stop() {
        // given
        MoveStrategy mockMoveStrategy = mockMoveStrategy(false);
        String carName = "test";

        // given
        Car car = new Car(carName, mockMoveStrategy).moveOrStop(1);

        // then
        Car expectedCar = new Car(carName, mockMoveStrategy, new CarPosition(List.of(false)));
        assertThat(car).isEqualTo(expectedCar);
    }

    @ParameterizedTest(name = "[{index}/2] 자동차 이동 횟수 반환")
    @CsvSource(value = {"false,0", "true,2"})
    void number_of_move(boolean movable, long expected) {
        // given
        Car car = new Car("test", mockMoveStrategy(movable)).moveOrStop(2);

        // when, then
        assertThat(car.numberOfMove()).isEqualTo(expected);
    }

    @Test
    void move_statuses_at() {
        // given
        Car car = new Car("test", mockMoveStrategy(true)).moveOrStop(2);

        // when, then
        assertThat(car.moveStatusesAt(2)).containsExactly(true, true);
    }

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}