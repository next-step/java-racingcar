package com.nextstep.javaRacing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RaceCarTest {

    private static final MoveStrategy mockMoveStrategy = () -> 1;

    @Test
    @DisplayName("이동하면 위치가 변한다")
    void move_이동하면_위치가_변한다() {
        Car car = new RaceCar("testCar", mockMoveStrategy);
        assertThat(car.position()).isEqualTo(0);
        car.move();
        assertThat(car.position()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤으로 이동한다")
    void move_랜덤으로_이동한다() {
        Car car = new RaceCar("testCar", new RandomMoveStrategy());
        for (int i = 0; i < 100; i++) {
            car.move();
        }
        assertThat(car.position()).isLessThan(100);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 9})
    @DisplayName("이동한 만큼 위치가 바뀐다")
    void position(int turns) {
        Car car = new RaceCar("testCar", mockMoveStrategy);
        for (int i = 0; i < turns; i++) {
            car.move();
        }
        assertThat(car.position()).isEqualTo(turns);
    }
}