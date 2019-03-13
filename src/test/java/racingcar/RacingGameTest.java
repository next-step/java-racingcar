package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void 자동차대수를입력한다() {
        RacingGame racingGame = new RacingGame();
        assertThat(2).isEqualTo(racingGame.setRacingCarCnt(2));
    }

    @Test
    public void 시도횟수를입력한다() {
        RacingGame racingGame = new RacingGame();
        racingGame.setTryCnt(5);
        assertThat(5).isEqualTo(racingGame.getTryCnt());
    }

    @Test
    public void 자동차한대가슷지4이상일경우전진한다() {
        RacingCar racingCar = new RacingCar();
        assertThat(1).isEqualTo(racingCar.go());
    }

    @Test
    public void 자동차한대가슷지4미만경우멈춘다() {
        RacingCar racingCar = new RacingCar();
        assertThat(0).isEqualTo(racingCar.stop());
    }

}
