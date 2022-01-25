package racingcar;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.IntStream;

public class RacingService {

    private final List<Car> cars;

    public RacingService(final List<Car> cars) {
        this.cars = cars;
    }

    public void drive(final List<Car> cars) {
        IntStream.range(0, cars.size())
                .forEach(idx -> cars.get(idx).moveForward());
    }

}
