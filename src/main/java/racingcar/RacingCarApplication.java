package racingcar;

public class RacingCarApplication {
    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int attemptCount = InputView.getAttemptCount();
        RacingGame racingGame = new RacingGame(new FourOrMore(new SystemRandomHolder()));
        RaceResult raceResult = racingGame.race(carCount, attemptCount);
        ResultView.printHistory(raceResult);
    }
}
