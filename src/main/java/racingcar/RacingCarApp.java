package racingcar;

import racingcar.model.RacingRecord;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int racingCarNumbers = inputView.getRacingCarNumbers();
        int racingRound = inputView.getRacingRound();

        RacingGame racingGame = new RacingGame(racingCarNumbers, racingRound);
        RacingRecord racingRecord = racingGame.start();

        ResultView.displayResult(racingRecord);

    }
}
