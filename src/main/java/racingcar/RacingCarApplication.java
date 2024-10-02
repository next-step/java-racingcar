package racingcar;

public class RacingCarApplication {
    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int attemptCount = InputView.getAttemptCount();
        int[][] history = RacingGame.race(carCount, attemptCount, new FourOrMore(), new SystemRandomHolder());
        ResultView.printHistory(history);
    }
}
