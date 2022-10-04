package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.strategy.RandomValueMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        String carName = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();
        ResultView.printResultMessage();
        RacingCarGame racingCarWinnerGame = new RacingCarGame(carName, tryCount);
        ResultView.printRacingCars(racingCarWinnerGame.play(new RandomValueMovingStrategy()));
        ResultView.printWinner(racingCarWinnerGame.findWinner());
    }
}
