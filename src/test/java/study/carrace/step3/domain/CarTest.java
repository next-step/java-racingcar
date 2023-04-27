package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;


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

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}