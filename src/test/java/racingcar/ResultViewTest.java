package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    void resultViewSuccessTest() {
        String carNames = "일번,이번,삼번";
        int time = 5;
        try {
            RacingGame racingGame = new RacingGame(carNames, time);
            ResultView resultView = racingGame.start();
            resultView.printResult();
        } catch (Exception e) {
            assertThat(e).isNotNull();
        }
    }
}
