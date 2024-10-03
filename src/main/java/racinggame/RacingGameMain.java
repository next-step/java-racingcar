package racinggame;

import racinggame.domain.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class RacingGameMain {
    public static void main(String[] args) {
        var carNames = InputView.readCarNames();
        var tryCount = InputView.readTryCount();
        var racingGame = new RacingGame(carNames);
        var gameResults = racingGame.start(tryCount);
        ResultView.printCarPositionByRound(gameResults);
    }
}
