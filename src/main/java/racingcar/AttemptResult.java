package racingcar;

import java.util.List;

public class AttemptResult {
    private final List<Car> cars;

    public AttemptResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarPositions() {
        return this.cars;
    }
}
