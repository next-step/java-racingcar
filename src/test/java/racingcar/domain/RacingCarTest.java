package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @DisplayName("레이싱 자동차를 전진 시킴")
    @Test
    void go() {
        RacingCar car = new RacingCar();
        MotorRacingRule moveRule = () -> true;
        car.racing(moveRule);
        assertThat(car.getMileage()).isPositive();
    }

    @DisplayName("레이싱 자동차를 정지 시킴")
    @Test
    void stop() {
        RacingCar car = new RacingCar();
        MotorRacingRule moveRule = () -> false;
        car.racing(moveRule);
        assertThat(car.getMileage()).isZero();
    }
}