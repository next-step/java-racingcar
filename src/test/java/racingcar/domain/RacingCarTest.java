package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 이름이 5자리 초과할 경우 exception을 발생한다.")
    void 자동차_이름_5자리_이상() {
        assertThatThrownBy(() -> new RacingCar("heeeee"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("자동차 전진에 boolean 값이 false 이면 멈춘다.")
    void 자동차_멈춤() {
        RacingCar racingCar = new RacingCar("hee");
        boolean movable = false;
        racingCar.move(movable);
        assertThat(racingCar).isEqualTo(new RacingCar("hee", 1));
    }

    @Test
    @DisplayName("자동차 전진에 boolean 값이 true일 때 전진한다.")
    void 자동차_전진_플래그() {
        RacingCar racingCar = new RacingCar("hee");
        boolean movable = true;
        racingCar.move(movable);
        assertThat(racingCar).isEqualTo(new RacingCar("hee", 2));
    }

    @Test
    @DisplayName("자동차를 전진 시킨다.")
    void 자동차_전진() {
        RacingCar racingCar = new RacingCar("hee");
        racingCar.move();
        assertThat(racingCar).isEqualTo(new RacingCar("hee", 2));
    }

    @Test
    @DisplayName("자동차 객체를 만들면, 자동차를 시작 상태로 세팅한다.")
    void 자동차_세팅() {
        RacingCar racingCar = new RacingCar("hee");
        assertThat(racingCar).isEqualTo(new RacingCar("hee", 1));
    }
}
