package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private final String[] carNames;
    private final int maxAttempts;

    public Rule(String[] carNames, int maxAttempts) {
        this.carNames = carNames;
        this.maxAttempts = maxAttempts;
    }

    public List<RacingCar> readyCars() {
        List<RacingCar> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new RacingCar(carName));
        }
        return cars;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }
}
