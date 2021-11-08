package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    public void 자동차_생성자() {
        assertThat(new RacingCar()).isEqualTo(new RacingCar());
    }

    @Test
    public void 전진_카운트_증가(){
        RacingCar racingCar = new RacingCar();
        racingCar.goOrStopRacing(4);
        assertThat(racingCar.getMoveCount()).isEqualTo(1);
    }
}
