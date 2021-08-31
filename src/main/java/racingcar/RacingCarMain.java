package racingcar;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingResult;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<RacingResult> results = new RacingGame(inputView.inputCar(), inputView.inputAttempt()).startRace();
        resultView.showRacing(results);

    }

}
