package racingcar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame;
    String[] names;
    RacingCar firstrCar;

    @Before
    public void setUp() throws Exception {
        names = new InputView().splitCarNames("minsu,ruru,sian");
        racingGame = new RacingGame(names, 4);
        List<RacingCar> racingCars = new ArrayList<>();
        firstrCar = new RacingCar(names[0], 5);
        racingCars.add(firstrCar);
        racingCars.add(new RacingCar(names[0], 3));
        racingGame.setRacingCars(racingCars);
    }

    @Test
    public void 자동차이름을입력한다() {
        assertThat(new InputView().splitCarNames("minsu,ruru,sian")).isEqualTo(names);
    }

    @Test
    public void 시도횟수를입력한다() {
        assertThat(4).isEqualTo(racingGame.getTryCnt());
    }

    @Test
    public void 자동차한대가슷지4이상일경우전진한다() {
        assertThat(firstrCar.move(4)).isEqualTo(6);
    }

    @Test
    public void 자동차한대가슷지4미만경우멈춘다() {
        assertThat(firstrCar.move(3)).isEqualTo(5);
    }

    @Test
    public void 우승자의_좌표가_5일때_우승자인지_확인() {
        assertThat(firstrCar.isMaxCoordinate(5)).isTrue();
    }

    @Test
    public void 우승자_좌표구하기() {
        assertThat(racingGame.getWinnerCoordinate()).isEqualTo(5);
    }
}
