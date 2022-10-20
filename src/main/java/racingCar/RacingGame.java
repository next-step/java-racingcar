package racingCar;

import java.util.Arrays;
import java.util.Random;

public class RacingGame {
    //    private final int numOfCars;
    private final RacingCar[] cars;
    private final int numOfRounds;

    public RacingGame(RacingCar[] cars, int numOfRounds) {
        this.cars = cars;
        this.numOfRounds = numOfRounds;
    }

    public void start() {
        for (int i = 0; i < numOfRounds; i++) {
            for (RacingCar car : cars) {
                car.tryMove(new Random().nextInt(10));
            }
        }
    }
}
