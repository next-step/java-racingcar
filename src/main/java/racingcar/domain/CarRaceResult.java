package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRaceResult {

    private final List<Cars> cars;

    public CarRaceResult() {
        this.cars = new ArrayList<>();
    }

    public List<Cars> get() {
        return this.cars;
    }

    public void add(Cars cars) {
        this.cars.add(cars.deepCopy());
    }

    public Cars getFinalResult() {
        return cars.get(getLastIndex());
    }

    public Distance getWinDistance() {
        return getFinalResult().findWinDistance();
    }

    public int getLastIndex() {
        return cars.size() - 1;
    }
}
