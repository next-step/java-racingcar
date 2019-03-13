package racingcar;

import java.util.List;

public class RacingResult {

    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

