package com.kakao.racingcar.domain.car;

import com.kakao.racingcar.history.CarHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @Test
    @DisplayName("움직이는 조건이 설정되었을 땐 conditionNumber에 상관없이 차가 움직인다.")
    void moveSuccess() {
        Car car = new Car("jyami", (move) -> true);
        CarHistory carHistory = car.tryMove(0);
        assertThat(carHistory.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("멈춤 조건이 설정되었을 땐 conditionNumber에 상관없이 차가 움직이지 않는다.")
    void moveFail() {
        Car car = new Car("jyami", (move) -> false);
        CarHistory carHistory = car.tryMove(10);
        assertThat(carHistory.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("차 생성시 유저 이름이 5자 이상이면 실패한다.")
    void carUserNameValidateFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("jyamiTest", (move) -> false));
    }

}
