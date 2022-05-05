package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("자동차와 움직인 자동차를 비교한다.")
    void racing_car_move() {
        RacingCar defaultCar = new RacingCar();
        RacingCar movedCar = new RacingCar();
        movedCar.move();

        assertThat(movedCar).isNotEqualTo(defaultCar);
    }
}
