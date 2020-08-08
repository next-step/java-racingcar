package racingcar;

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
            racingCar.setCarMover(new RandomCarMover());

            racingCar.race(attemptNumber);
            racingCars.add(racingCar);
        }

        return RacingResult.aggregate(attemptNumber, racingCars);
    }

    public boolean isAvailableGame() {
        return carNumber > 0 && attemptNumber > 0;
    }
}
