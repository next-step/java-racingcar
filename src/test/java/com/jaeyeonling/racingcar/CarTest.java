package com.jaeyeonling.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("Car 객체 생성")
    @Test
    void createCar() {
        assertThat(new Car()).isNotNull();
    }

    @DisplayName("Car 객체 생성")
    @Test
    void getStatus() {
        assertThat(new Car().getStatus()).isNotNull();
    }

    @DisplayName("이동 후 위치 변경 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 5, 4, 35, 41, 23 })
    void move(final int moveCount) {
        // given
        final Car car = new Car();

        // when
        for (int i = 0; i < moveCount; i++) {
            car.moveForward();
        }

        // then
        assertThat(car.getPosition()).isEqualTo(moveCount);
    }
}
