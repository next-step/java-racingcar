package com.kakao.racingcar.history;

import com.kakao.racingcar.domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarHistoryTest {

    @Test
    @DisplayName("입력된 차의 현재 정보를 객체안에 기록한다.")
    void getPosition() {
        Car car = new Car("jyami", (move) -> true);
        CarHistory carHistory = car.tryMove(10);
        assertThat(carHistory).isEqualTo(new CarHistory(1, "jyami"));
    }

}
