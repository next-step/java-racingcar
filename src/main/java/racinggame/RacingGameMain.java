package racinggame;

import java.util.List;

public class RacingGameMain {
    public static void main(String[] args) {
        var carCount = InputView.readCarCount();
        var tryCount = InputView.readTryCount();
        var racingGame = new RacingGame();
        List<List<Integer>> gameResults = racingGame.start(carCount, tryCount);
        ResultView.printCarPositionByRound(gameResults);
    }
}
