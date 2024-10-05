package racingcar;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        String carNames = InputView.getCarCount();
        int attemptCount = InputView.getAttemptCount();

        RacingGame racingGame = new RacingGame(new FourOrMore(new SystemRandomHolder()));
        List<Car> cars = racingGame.createCars(carNames);
        RaceResult raceResult = racingGame.race(cars, attemptCount);
        List<Car> winners = racingGame.getWinners(raceResult.getLastAttemptResult().getCars());

        ResultView.printHistory(raceResult, winners);
    }
}
