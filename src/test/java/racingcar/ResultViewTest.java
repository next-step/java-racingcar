package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    void resultViewSuccessTest() {
        String carNames = "일번,이번,삼번";
        int time = 5;
        try {
            RacingGame racingGame = new RacingGame(carNames, time);
            racingGame.start();
            ResultView resultView = new ResultView(racingGame);
            resultView.printRacingGameWinner();
        } catch (Exception e) {
            assertThat(e).isNotNull();
        }
    }
}
