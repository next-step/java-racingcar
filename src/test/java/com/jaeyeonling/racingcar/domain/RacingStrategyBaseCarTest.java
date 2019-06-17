package com.jaeyeonling.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingStrategyBaseCarTest {

    @DisplayName("이동 후 위치 변함 확인")
    @Test
    void simpleMove() {
        // given
        final Car car = new Car(new RacingStrategy());

        // when
        car.moveForward(RacingCondition.MOVE.condition);

        // then
        assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_POSITION + 1);
    }

    @DisplayName("이동 후 위치 변함 없는지 확인")
    @Test
    void simpleNotMove() {
        // given
        final Car car = new Car(new RacingStrategy());

        // when
        car.moveForward(RacingCondition.STAY.condition);

        // then
        assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_POSITION);
    }

    @DisplayName("무조건 이동하는 조건 입력 시 위치 변경 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 4, 35, 41, 23 })
    void move(final int moveCount) {
        // given
        final Car car = new Car(new RacingStrategy());

        // when
        for (int i = 0; i < moveCount; i++) {
            car.moveForward(RacingCondition.MOVE.condition);
        }

        // then
        assertThat(car.getPosition()).isEqualTo(moveCount + Car.DEFAULT_POSITION);
    }

    @DisplayName("이동 안되는 조건 입력 시 위치 변경 안되는 것 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 4, 35, 41, 23 })
    void notMove(final int moveCount) {
        // given
        final Car car = new Car(new RacingStrategy());

        // when
        for (int i = 0; i < moveCount; i++) {
            car.moveForward(RacingCondition.STAY.condition);
        }

        // then
        assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_POSITION);
    }

    enum RacingCondition {
        MOVE(RacingStrategy.MORE_THAN_MOVING_CONDITION + 1),
        STAY(RacingStrategy.MORE_THAN_MOVING_CONDITION - 1);

        private int condition;

        RacingCondition(final int condition) {
            this.condition = condition;
        }
    }
}
