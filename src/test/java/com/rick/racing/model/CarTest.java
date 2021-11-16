package com.rick.racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private static final String CAR_NAME = "TESTER";

    @Test
    @DisplayName("인스턴스 정상 생성 확인")
    public void create() {
        final Car carA = Car.create(CAR_NAME);
        final Car carB = Car.create(CAR_NAME);

        assertThat(carA.hasSameName(carB))
            .isTrue();
        assertThat(carA.isPositionAt(carB))
            .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    @DisplayName("자동차 이동 테스트")
    public void moveForward(int tryCount) {
        Car car = Car.create(CAR_NAME);

        for (int i = 0; i < tryCount; i++) {
            car.moveForward();
        }

        CarPosition carPosition = car.position();
        assertThat(carPosition.asInt())
            .isEqualTo(tryCount);
    }

}
