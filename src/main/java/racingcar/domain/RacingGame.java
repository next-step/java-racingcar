package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String NAME_SPLIT_REGEX = ",";

    private Cars cars;

    private int tryCount;

    public RacingGame(String carNames, int tryCount) {
        this.cars = initializeCars(carNames);
        this.tryCount = tryCount;
    }

    private Cars initializeCars(String carNames) {
        validateCarNames(carNames);
        String[] names = carNames.split(NAME_SPLIT_REGEX);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(new RacingCarMovableStrategy(), name));
        }
        return new Cars(cars);
    }

    private void validateCarNames(String carNames) {
        if (carNames == null || "".equals(carNames)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> race() {
        tryCount--;
        return cars.moveAll();
    }

    public boolean isRaceEnd() {
        return tryCount <= 0;
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

}
