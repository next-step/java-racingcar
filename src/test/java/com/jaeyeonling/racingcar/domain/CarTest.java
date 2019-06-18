package com.jaeyeonling.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

}
