package racingcar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        RacingResult result = new RacingResult();
        String[] names = result.splitCarName("minsu,ruru,sian");
        List<RacingCar> resultCarNames = result.createRacingCar(names);
        racingGame = new RacingGame(resultCarNames, 4);
    }

    @Test
    public void 자동차이름을입력한다() {

        List<String> carNames = new ArrayList<>();
        carNames.add("minsu");
        carNames.add("ruru");
        carNames.add("sian");
        assertThat(carNames).isEqualTo(racingGame.getRacingCarNames());
    }

    @Test
    public void 시도횟수를입력한다() {
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
