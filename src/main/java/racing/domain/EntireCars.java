package racing.domain;

import racing.generator.ValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntireCars {

    private List<Car> cars = new ArrayList<>();

    private EntireCars() {}

    public static EntireCars of(List<String> carNames) {

        validate(carNames);

        EntireCars entireCars = new EntireCars();
        entireCars.cars = carNames.stream().map(Car::of).collect(Collectors.toList());
        return entireCars;
    }

    public void race(ValueGenerator valueGenerator) {

        cars.forEach(car -> car.race(valueGenerator.generateIntValue()));
    }

    public List<Car> getCars() {

        return cars;
    }

    private static void validate(List<String> carNames) {

        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("차의 개수는 1개 이상이어야 합니다.");
        }
    }
}
