package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingModelTest {

    @Test
    @DisplayName("자동차를 전진 시킨다.")
    void 자동차_전진() {
        RacingCar racingCar = new RacingCar();
        racingCar.move();
        assertThat(racingCar.getStatus()).isEqualTo("--");
    }

    @Test
    @DisplayName("자동차 객체를 만들면, 자동차를 시작 상태로 세팅한다.")
    void 자동차_세팅() {
        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.getStatus()).isEqualTo("-");
    }
}
