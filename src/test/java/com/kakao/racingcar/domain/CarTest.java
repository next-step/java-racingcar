package com.kakao.racingcar.domain;

import com.kakao.racingcar.domain.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.kakao.racingcar.config.CarConfig.MOVE_PERCENTAGE;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("차에는 생성시에 유저이름이 있다.")
    void carIdentifyNumber() {
        String userName = "jyami";
        Car car = new Car(userName);
        assertThat(car.getUserName()).isEqualTo(userName);
    }

    @Test
    @DisplayName("기준 숫자 4보다 크거나 같을 경우에만 차가 움직인다.")
    void moveSuccess() {
        Car car = new Car("jyami");
        assertThat(car.getPosition()).isEqualTo(0);
        car.tryMove(MOVE_PERCENTAGE);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("기준 숫자보다 더 작을 경우엔 차가 움직이지 않는다.")
    void moveFail() {
        Car car = new Car("jyami");
        car.tryMove(1);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
