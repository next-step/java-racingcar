package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {


    @Test
    @DisplayName("자동차 전진에 boolean 값이 false 이면 멈춘다.")
    void 자동차_멈춤() {
        RacingCar racingCar = new RacingCar("heechul");
        boolean movable = false;
        racingCar.move(movable);
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 전진에 boolean 값이 true일 때 전진한다.")
    void 자동차_전진_플래그() {
        RacingCar racingCar = new RacingCar("heechul");
        boolean movable = true;
        racingCar.move(movable);
        assertThat(racingCar.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차를 전진 시킨다.")
    void 자동차_전진() {
        RacingCar racingCar = new RacingCar("heechul");
        racingCar.move();
        assertThat(racingCar.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 객체를 만들면, 자동차를 시작 상태로 세팅한다.")
    void 자동차_세팅() {
        RacingCar racingCar = new RacingCar("heechul");
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }
}
