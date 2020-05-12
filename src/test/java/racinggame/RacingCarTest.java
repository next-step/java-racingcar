package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    private RacingCar racingCar = new RacingCar();

    @DisplayName("자동차를 신규 생성한다.")
    @Test
    void newRacingCarTest() {
        assertThat(RacingCar.newRacingCar()).isNotNull();
    }
}
