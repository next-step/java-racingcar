package racingcar;

import calculator.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class RacingGame {
    private int carNumber;
    private int attemptNumber;

    private RacingGame(int carNumber, int attemptNumber) {
        this.carNumber = carNumber;
        this.attemptNumber = attemptNumber;
    }

    public static RacingGame of(int carNumber, int attemptNumber) {
        return new RacingGame(carNumber, attemptNumber);
    }

    RacingResult progress() {
        List<RacingVehicle> racingCars = new ArrayList<>();

        for (int car = 0; car < carNumber; car++) {
            RacingCar racingCar = new RacingCar();
            racingCar.setCarMover(new RandomNumberMover());

            racingCar.race(attemptNumber);
            racingCars.add(racingCar);
        }

        return RacingResult.aggregate(attemptNumber, racingCars);
    }

    public void checkAvailableGame() {
        if (carNumber < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RACING_CAR_NUMBER);
        }

        if (attemptNumber < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RACING_ATTEMPT_NUMBER);
        }
    }
}
