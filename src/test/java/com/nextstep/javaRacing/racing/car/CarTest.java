package com.nextstep.javaRacing.racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    private static final MoveStrategy mockMoveStrategy = () -> 1;

    @Test
    @DisplayName("자동차의 생성")
    void car_generater() {
        String carName = "carName";
        Car car = new Car(carName, mockMoveStrategy);

        assertAll(
                () -> assertThat(car.name).isEqualTo(carName),
                () -> assertThat(car.position).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("이동하면 위치가 변한다")
    void move_이동하면_위치가_변한다() {
        Car car = new Car("testCar", mockMoveStrategy);
        int startPosition = car.getPosition();
        car.move();
        int movedPosition = car.getPosition();

        assertAll(
                () -> assertThat(startPosition).isEqualTo(0),
                () -> assertThat(movedPosition).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("이동하면 크기가 커진다")
    void move_compare() {
        Car stoppedCar = new Car("stoppedCar", mockMoveStrategy);
        Car movedCar = new Car("movedCar", mockMoveStrategy);
        movedCar.move();
        assertThat(movedCar.compareTo(stoppedCar)).isGreaterThan(0);
    }

    @Test
    @DisplayName("위치와 이름을 특정 포맷으로 출력한다")
    void printPosition() {
        Car car = new Car("car", mockMoveStrategy);
        car.move();

        assertThat(car.printPosition()).isEqualTo("-|car");
    }
}