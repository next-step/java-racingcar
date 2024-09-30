package racinggame;

public class RacingGameMain {
    public static void main(String[] args) {
        var carCount = InputView.readCarCount();
        var tryCount = InputView.readTryCount();
        var racingGame = new RacingGame();
        racingGame.start(carCount, tryCount);
    }
}
