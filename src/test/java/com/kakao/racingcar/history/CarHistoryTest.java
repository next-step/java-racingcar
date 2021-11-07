package com.kakao.racingcar.history;

import com.kakao.racingcar.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarHistoryTest {

    @Test
    @DisplayName("입력된 차의 현재 위치를 객체안에 기록한다.")
    void of() {
        Car car = new Car();
        car.tryMove(10);
        CarHistory carHistory = CarHistory.of(car);
        assertThat(carHistory.getPosition()).isEqualTo(1);
    }
}
