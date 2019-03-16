package racingcar;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        InputView input = new InputView();
        String[] names = input.splitCarNames("minsu,ruru,sian");
        RacingResult racingCarResult = new RacingResult();
        List<RacingCar> resultCarNames = racingCarResult.createRacingCar(names);
        racingGame = new RacingGame(resultCarNames, 4);
    }

    @Test
    public void 자동차이름을입력한다() {
        String[] expectedNames = {"minsu", "ruru", "sian"};
        assertThat(new InputView().splitCarNames("minsu,ruru,sian")).isEqualTo(expectedNames);//
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
