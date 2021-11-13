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

    @Test
    @DisplayName("두 차의 위치가 같은지 비교한다.")
    void equalsPositon() {
        CarHistory carHistory1 = new CarHistory(1, "jyami");
        CarHistory carHistory2 = new CarHistory(1, "mj");
        assertThat(carHistory1.isEqualPosition(carHistory2)).isTrue();
    }

    @Test
    @DisplayName("차의 이름, 위치가 같으면 같은 히스토리이다.")
    void equalsPosition() {
        CarHistory carHistory1 = new CarHistory(1, "jyami");
        CarHistory carHistory2 = new CarHistory(1, "jyami");
        assertThat(carHistory1).isEqualTo(carHistory2);
    }

}
