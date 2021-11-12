package racingcar;

import util.RandomGenerator;

public class RacingManager {

    public int progressCar(Car car) {
        int randomNumber = RandomGenerator.generateNumberBetweenZeroToNine();

        return car.runOrStop(randomNumber);
    }
}
