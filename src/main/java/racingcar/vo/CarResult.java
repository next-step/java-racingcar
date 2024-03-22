package racingcar.vo;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;
import racingcar.domain.cars.Cars;

public class CarResult {

    private final Name name;
    private final Position position;

    private CarResult(final Car car) {
        this.name = car.name();
        this.position = car.position();
    }

    public String name() {
        return this.name.toString();
    }

    public String positionResult() {
        return this.position.toString();
    }

    public static List<CarResult> fromCars(final Cars cars) {
        return cars.cars()
                .stream()
                .map(CarResult::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
