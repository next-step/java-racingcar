package com.jaeyeonling.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    @DisplayName("Car 생성")
    @Test
    void create() {
        // given
        final MoveStrategy moveStrategy = new RacingStrategy();

        // when
        final Car car = new Car("TestCar", moveStrategy);

        // then
        assertThat(car).isNotNull();
    }

    @DisplayName("car 기본 위치 셋팅")
    @Test
    void carDefaultPosition() {
        // given
        final MoveStrategy moveStrategy = new RacingStrategy();

        // when
        final Car car = new Car("TestCar", moveStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_POSITION);
    }

    @DisplayName("car 이름 셋팅")
    @Test
    void carName() {
        // given
        final String carName = "TestCar";
        final MoveStrategy moveStrategy = new RacingStrategy();

        // when
        final Car car = new Car(carName, moveStrategy);

        // then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("car 위치 이동")
    @Test
    void carMovePosition() {
        // given
        final MoveStrategy moveStrategy = new RacingStrategy();

        // when
        final Car car = new Car("TestCar", moveStrategy);
        car.moveForward(RacingStrategy.MORE_THAN_MOVING_CONDITION);

        // then
        assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_POSITION + 1);
    }

    @DisplayName("car 위치 확인")
    @Test
    void carMatchPosition() {
        // given
        final MoveStrategy moveStrategy = new RacingStrategy();

        // when / then
        final Car car = new Car("TestCar", moveStrategy);

        assertThat(car.isMatchPosition(Car.DEFAULT_POSITION)).isTrue();

        car.moveForward(RacingStrategy.MORE_THAN_MOVING_CONDITION);
        assertThat(car.isMatchPosition(Car.DEFAULT_POSITION + 1)).isTrue();
    }


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
        final int moveCondition = 100;
        int currentIndex = Car.DEFAULT_POSITION;

        final Car car = new Car("TestCar", i -> i == moveCondition);
        assertThat(car.getPosition()).isEqualTo(currentIndex);

        car.moveForward(moveCondition);
        currentIndex++;
        assertThat(car.getPosition()).isEqualTo(currentIndex);

        car.moveForward(0);
        assertThat(car.getPosition()).isEqualTo(currentIndex);
    }
}
