package com.kkambi.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final String LOCATION_UNIT = "-";

    @DisplayName("자동차 전진")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void move(int maxTimes) {
        // given
        Car car = new Car();
        StringBuilder expectedLocation = new StringBuilder();

        // when
        for (int times = 0; times < maxTimes; times++) {
            car.move();
            expectedLocation.append(LOCATION_UNIT);
        }

        // then
        assertThat(car.getLocation()).contains(LOCATION_UNIT);
        assertThat(car.getLocation()).isEqualTo(expectedLocation.toString());
    }
}