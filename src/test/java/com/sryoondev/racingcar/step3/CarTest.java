package com.sryoondev.racingcar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차의 전진 테스트")
    public void testMove() {
        Car car = new Car();
        car.move();
        assertThat(car.getMoveDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차의 멈춤 테스트")
    void testStop() {
        Car car = new Car();
        car.stop();
        assertThat(car.getMoveDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("입력 값에 따라 전진하거나 멈추는지 테스트")
    @CsvSource(value = {"true,1", "false,0"})
    void testRace(boolean movable, int moveDistance) {
        Car car = new Car();
        car.race(movable);
        assertThat(car.getMoveDistance()).isEqualTo(moveDistance);
    }

    @ParameterizedTest
    @DisplayName("이동거리 테스트")
    @ValueSource(ints = {3, 10})
    void testGetMoveDistance(int count) {
        Car car = new Car();
        for (int i = 0; i < count; i++) {
            car.move();
        }
        assertThat(car.getMoveDistance()).isEqualTo(count);
    }
}
