package racing;

import racing.exception.AttemptsCountNegativeNumberException;
import racing.exception.CarsNullPointerException;

import java.util.stream.IntStream;

public class RacingGame {
    private final RacingCars racingCars;
    private final RacingGameManagement racingGameManagement;
    private final int attemptsCount;

    public RacingGame(RacingCars racingCars, int attemptsCount, RacingGameManagement carDrivingStatus) {
        this.racingCars = racingCars;
        this.attemptsCount = attemptsCount;
        this.racingGameManagement = carDrivingStatus;
    }

    public void StartRacing() {
        validateObjects();
        IntStream.range(0, attemptsCount)
                .forEach(i -> moveCars());
    }

    private void validateObjects() {
        if (racingCars == null) {
            throw new CarsNullPointerException();
        }

        if (attemptsCount <= 0) {
            throw new AttemptsCountNegativeNumberException();
        }
    }

    private void moveCars() {
        racingCars.forEach(car -> car.move(racingGameManagement));
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }

}
