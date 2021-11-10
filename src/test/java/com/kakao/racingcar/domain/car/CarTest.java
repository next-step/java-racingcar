package com.kakao.racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("차에는 생성시에 유저이름이 있다.")
    void carIdentifyNumber() {
        String userName = "jyami";
        Car car = new Car(userName, new RandomStrategy());
        assertThat(car.getUserName()).isEqualTo(userName);
    }

    @Test
    @DisplayName("움직이는 조건이 설정되었을 땐 conditionNumber에 상관없이 차가 움직인다.")
    void moveSuccess() {
        Car car = new Car("jyami", (move) -> true);
        assertThat(car.getPosition()).isEqualTo(0);
        car.tryMove(0);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("멈춤 조건이 설정되었을 땐 conditionNumber에 상관없이 차가 움직이지 않는다..")
    void moveFail() {
        Car car = new Car("jyami", (move) -> false);
        assertThat(car.getPosition()).isEqualTo(0);
        car.tryMove(10);
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
