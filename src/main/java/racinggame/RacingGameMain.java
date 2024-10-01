package racinggame;

import racinggame.domain.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class RacingGameMain {
    public static void main(String[] args) {
        var carCount = InputView.readCarCount();
        var tryCount = InputView.readTryCount();
        var racingGame = new RacingGame();
        var gameResults = racingGame.start(carCount, tryCount);
        ResultView.printCarPositionByRound(gameResults);
    }
}
