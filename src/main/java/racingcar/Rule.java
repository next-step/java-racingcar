package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private final int countOfCar;
    private final int maxAttempts;

    public Rule(int countOfCar, int maxAttempts) {
        this.countOfCar = countOfCar;
        this.maxAttempts = maxAttempts;
    }

    public List<RacingCar> readyCars() {
        List<RacingCar> cars = new ArrayList<>(countOfCar);
        for (int count = 0; count < countOfCar; count++) {
            cars.add(new RacingCar());
        }
        return cars;
    }

    public int getCountOfCar() {
        return countOfCar;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }
}
