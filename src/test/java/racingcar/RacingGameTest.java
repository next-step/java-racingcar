package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame(2, 4);
    }

    @Test
    public void 자동차대수를입력한다() {
        assertThat(2).isEqualTo(racingGame.getRacingCars().size());
    }

    @Test
    public void 시도횟수를입력한다() {
        racingGame = new RacingGame(2, 4);
        assertThat(4).isEqualTo(racingGame.getTryCnt());
    }

    @Test
    public void 자동차한대가슷지4이상일경우전진한다() {
        RacingCar racingCar = new RacingCar();
        assertThat(1).isEqualTo(racingCar.move(4));
    }

    @Test
    public void 자동차한대가슷지4미만경우멈춘다() {
        RacingCar racingCar = new RacingCar();
        assertThat(0).isEqualTo(racingCar.move(0));
    }
}
