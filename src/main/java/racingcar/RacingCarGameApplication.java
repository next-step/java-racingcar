package racingcar;

import racingcar.service.RacingCarGame;
import racingcar.strategy.RandomValueMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();
        ResultView.printResultMessage();
        RacingCarGame racingCarGame = new RacingCarGame(carCount, tryCount);
        racingCarGame.play(new RandomValueMovingStrategy());
    }
}
