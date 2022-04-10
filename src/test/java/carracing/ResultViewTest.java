package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {
    @Test
    void 자동차_위치_출력() {
        RacingCar racingCar = new RacingCar();
        racingCar.setPosition(3);
        assertThat(ResultView.makeRacingCarRoute(racingCar)).isEqualTo("---") ;
    }
}