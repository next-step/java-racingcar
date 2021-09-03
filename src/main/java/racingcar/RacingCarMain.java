package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        List<RacingResult> result = new RacingGame(InputView.inputCar(), InputView.inputAttempt()).startRace();
        ResultView.showRacing(result);
    }

}
