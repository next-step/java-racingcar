package racingcar.domain.dto;

import racingcar.domain.Car;

import java.util.List;

public class RacingCarResult {
    private final List<Car> cars;

    public RacingCarResult(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
