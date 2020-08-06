package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author daheekim
 * @version : 0.0.0
 */
public class RacingGame {
    private int carNumber;
    private int attemptNumber;
    private Random random;

    private RacingGame(int carNumber, int attemptNumber) {
        this.carNumber = carNumber;
        this.attemptNumber = attemptNumber;
        this.random = new Random();
    }

    public static RacingGame of(int carNumber, int attemptNumber) {
        return new RacingGame(carNumber, attemptNumber);
    }

    RacingResult race() {
        List<RacingCar> racingCars = new ArrayList<>();

        for (int car = 0; car < carNumber; car++) {
            RacingCar racingCar = RacingCar.create(random);
            racingCar.race(attemptNumber);

            racingCars.add(racingCar);
        }

        return RacingResult.aggregate(attemptNumber, racingCars);
    }

    public boolean isAvailableGame() {
        return carNumber >= 0 && attemptNumber >= 0;
    }
}
