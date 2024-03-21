package racingcar.vo;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.cars.Cars;

public class CarResult {

    private final String name;
    private final int position;

    private CarResult(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }

    public static List<CarResult> fromCars(final Cars cars) {
        return cars.cars()
                .stream()
                .map(car -> new CarResult(car.name(), car.position()))
                .collect(Collectors.toList());
    }
}
