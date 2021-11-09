package racingcargame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcargame.ui.InputView;
import racingcargame.ui.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    private final RacingCarGame racingCarGame = new RacingCarGame(new InputView(), new ResultView());

    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void prepareRacingCarsTest(int carCount) {
        racingCarGame.setCarCount(carCount);

        racingCarGame.prepareRacingCars();

        assertThat(racingCarGame.getRacingCars().size()).isEqualTo(carCount);
        assertThat(racingCarGame.getCarCount()).isEqualTo(-1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void moveAndPrintResultTest(int tryCount) {
        racingCarGame.setTryCount(tryCount);

        racingCarGame.moveAndPrintResult();

        assertThat(racingCarGame.getTryCount()).isEqualTo(-1);
    }
}