package com.sryoondev.racingcar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @ParameterizedTest
    @DisplayName("입력 값에 따라 전진하거나 멈추는지 테스트")
    @CsvSource(value = {"true,1", "false,0"})
    void testRace(boolean movable, int moveDistance) {
        Car car = new Car();
        car.race(movable);
        assertThat(car.getMoveDistance()).isEqualTo(moveDistance);
    }
}
