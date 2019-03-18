package racingcar;

import org.junit.Before;
import org.junit.Test;
import racingcar.utils.Constant;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.InputView.splitCarNames;

public class RacingGameTest {
    RacingGame racingGame;
    RacingResult racingResult;
    String[] names;
    RacingCar firstCar;

    @Before
    public void setUp() throws Exception {
        names = splitCarNames("minsu,ruru,sian");
        racingGame = new RacingGame(names, 4);
        List<RacingCar> racingCars = Arrays.asList(
                new RacingCar(names[0], 1)
                , new RacingCar(names[1], 0)
                , new RacingCar(names[2], 0)
        );
        firstCar = racingCars.get(0);
        racingResult = new RacingResult(racingCars);
    }

    @Test
    public void 자동차이름을입력한다() {
        assertThat(splitCarNames("minsu,ruru,sian")).isEqualTo(names);
    }

    @Test
    public void 자동차한대가슷지4이상일경우전진한다() {
        assertThat(firstCar.move(4)).isEqualTo(2);
    }

    @Test
    public void 자동차한대가슷지4미만경우멈춘다() {
        assertThat(firstCar.move(3)).isEqualTo(1);
    }

    @Test
    public void 우승자의_좌표가_1일때_우승자인지_확인() {
        firstCar.move(Constant.NUMBER_4);
        assertThat(firstCar.isMaxCoordinate(2)).isTrue();
    }

    @Test
    public void 우승자_좌표구하기() {
        assertThat(racingResult.findWinners()).hasSize(1);
    }

    @Test
    public void 우승자_이름_구하기() {
        assertThat(racingGame.getWinnerName()).contains("minsu");
    }
}
