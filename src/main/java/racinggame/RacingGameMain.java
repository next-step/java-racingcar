package racinggame;

public class RacingGameMain {
    public static void main(String[] args) {
        var carCount = InputView.readCarCount();
        var tryCount = InputView.readTryCount();
        var racingGame = new RacingGame();
        var gameResults = racingGame.start(carCount, tryCount);
        ResultView.printCarPositionByRound(gameResults);
    }
}
