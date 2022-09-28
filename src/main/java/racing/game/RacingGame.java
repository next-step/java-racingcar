package racing.game;

import racing.game.result.RacingResult;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final int numberOfAttempts;
    private final RacingResult racingResult;

    public RacingGame(List<Car> cars, int numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
        this.racingResult = new RacingResult(numberOfAttempts);
    }


    public RacingResult run() {
        runRacing();
        return racingResult;
    }


    private void runRacing() {
        for (int i = 0; i < numberOfAttempts; i++) {
            runAndSaveRound(i);
        }
    }

    private void runAndSaveRound(int roundNumber) {
        for (Car car : cars) {
            car.move();
            saveCarRoundResult(car, roundNumber);
        }
    }

    private void saveCarRoundResult(Car car, int roundNumber) {
        racingResult.saveCarRoundResult(car, roundNumber);
    }

}
