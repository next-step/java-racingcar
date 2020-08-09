package racingcar;

import exception.ExceptionMessage;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class RacingGame {
    private int attemptNumber;
    private RacingCars racingCars;

    private RacingGame(RacingCars racingCars, int attemptNumber) {
        this.racingCars = racingCars;
        this.attemptNumber = attemptNumber;
    }

    public static RacingGame of(List<String> carNames, int attemptNumber) {
        RacingCars racingCars = carNames.stream()
                .map(RacingCar::new)
                .collect(collectingAndThen(toList(), RacingCars::new));

        return new RacingGame(racingCars, attemptNumber);
    }

    RacingResult progress(CarMover carMover) {
        racingCars.race(carMover, attemptNumber);

        return RacingResult.aggregate(attemptNumber, racingCars);
    }

    public void checkAvailableGame() {
        if (racingCars.size() < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RACING_CAR_NUMBER);
        }

        if (attemptNumber < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RACING_ATTEMPT_NUMBER);
        }

        racingCars.checkNameValidation();
    }
}
