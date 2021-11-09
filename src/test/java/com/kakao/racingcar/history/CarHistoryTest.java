package com.kakao.racingcar.history;

import com.kakao.racingcar.domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarHistoryTest {

    @Test
    @DisplayName("입력된 차의 현재 위치를 객체안에 기록한다.")
    void getPosition() {
        Car car = new Car("jyami");
        car.tryMove(10);
        CarHistory carHistory = CarHistory.of(car);
        assertThat(carHistory.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("입력된 차의 유저 이름을 객체안에 기록한다.")
    void getName() {
        Car car = new Car("jyami");
        car.tryMove(10);
        CarHistory carHistory = CarHistory.of(car);
        assertThat(carHistory.getPosition()).isEqualTo(1);
    }
}
