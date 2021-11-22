package com.rick.racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.rick.racing.controller.SettableCarMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private static final String CAR_NAME = "TSTR";

    @Test
    @DisplayName("인스턴스 정상 생성 확인")
    public void create() {
        final Car carA = Car.create(CAR_NAME);
        final Car carB = Car.create(CAR_NAME);

        assertThat(carA.equals(carB))
            .isTrue();
        assertThat(carA.isPositionAt(carB))
            .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    @DisplayName("자동차 정상 이동 테스트")
    public void moveForward(int tryCount) {
        Car car = Car.create(CAR_NAME);
        SettableCarMovingStrategy carMovingDecider = SettableCarMovingStrategy.create();
        carMovingDecider.setGo(true);

        for (int i = 0; i < tryCount; i++) {
            car.move(carMovingDecider);
        }

        CarPosition carPosition = car.getPosition();
        assertThat(carPosition.asInt())
            .isEqualTo(tryCount);
    }

    @Test
    @DisplayName("자동차 정지 테스트")
    public void doNotMove() {
        final int expected = 0;
        Car car = Car.create(CAR_NAME);
        SettableCarMovingStrategy carMovingDecider = SettableCarMovingStrategy.create();
        carMovingDecider.setGo(false);

        car.move(carMovingDecider);

        CarPosition carPosition = car.getPosition();

        assertThat(carPosition.asInt())
            .isEqualTo(expected);
    }

}
