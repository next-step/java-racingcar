package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;

public class RacingResult {

    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingResult getInstance(List<Car> cars) {
        return new RacingResult(cars);
    }

    public int getCarCount() {
        return this.cars.size();
    }
}
