package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        String[] carNames = InputView.insertCar();
        int moveCount = InputView.insertMoveCount();
        InputView.inputClose();

        RacingGame racing = new RacingGame(carNames, moveCount);
        while (racing.canRace()) {
            ResultView.printRaceResult(racing.startRaceAndReduceCount());
        }
        ResultView.printWinnerName(racing.findWinnerNames());
    }
}
