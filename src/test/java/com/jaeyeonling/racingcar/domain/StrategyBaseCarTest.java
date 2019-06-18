package com.jaeyeonling.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyBaseCarTest {

    @DisplayName("무조건 이동하는 조건 입력 시 위치 변경 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 4, 35, 41, 23 })
    void move(final int moveCount) {
        // given
        final Car car = new Car("TestCar", i -> true);

        // when
        for (int i = 0; i < moveCount; i++) {
            car.moveForward(0);
        }

        // then
        assertThat(car.getPosition()).isEqualTo(moveCount + Car.DEFAULT_POSITION);
    }

    @DisplayName("이동 안되는 조건 입력 시 위치 변경 안되는 것 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 4, 35, 41, 23 })
    void notMove(final int moveCount) {
        // given
        final Car car = new Car("TestCar", i -> false);

        // when
        for (int i = 0; i < moveCount; i++) {
            car.moveForward(0);
        }

        // then
        assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_POSITION);
    }

    @DisplayName("정해진 타이밍에 이동 시 위치 변경 확인")
    @Test
    void sometimeMove() {
        final List<Boolean> movingCondition = List.of(true, true, true, false, false, true, false, true, false);
        final MoveStrategy moveStrategy = new MockMoveStrategy(movingCondition);
        final Car car = new Car("TestCar", moveStrategy);

        int expectedPosition = Car.DEFAULT_POSITION;

        for (final boolean isMove : movingCondition) {
            car.moveForward(0);

            if (isMove) {
                expectedPosition++;
            }

            assertThat(car.getPosition()).isEqualTo(expectedPosition);
        }
    }
}
