package racingcargame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.domain.RacingCar;
import racingcargame.ui.InputView;
import racingcargame.ui.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    private final RacingCarGame racingCarGame = new RacingCarGame(new InputView(), new ResultView());

    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void prepareRacingCarsTest(int carCount) {
        List<RacingCar> racingCars = racingCarGame.prepareRacingCars(carCount);

        assertThat(racingCars.size()).isEqualTo(carCount);
    }

}
