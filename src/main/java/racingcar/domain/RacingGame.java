package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {

    private Cars cars;

    private int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.cars = initializeCars(carNames);
        this.tryCount = tryCount;
    }

    private Cars initializeCars(String[] names) {
        validateCarNames(names);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(new RacingCarMovableStrategy(), name));
        }
        return new Cars(cars);
    }

    private void validateCarNames(String[] names) {
        if (Objects.isNull(names)) {
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

}
