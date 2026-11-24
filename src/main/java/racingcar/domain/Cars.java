package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this(createCars(names));
    }

    public Cars(Car... cars) {
        validateNotEmpty(cars);
        validateUniqueNames(cars);
        this.cars = List.of(cars);
    }

    private static Car[] createCars(List<String> names) {
        if (names == null) {
            return new Car[0];
        }
        return names.stream()
                .map(Car::new)
                .toArray(Car[]::new);
    }

    private static void validateNotEmpty(Car[] cars) {
        if (cars == null || cars.length == 0) {
            throw new IllegalArgumentException("at least one car is required");
        }
    }

    private static void validateUniqueNames(Car[] cars) {
        Set<CarName> names = new HashSet<>();
        for (Car car : cars) {
            addUniqueName(names, car.getName());
        }
    }

    private static void addUniqueName(Set<CarName> names, CarName name) {
        if (!names.add(name)) {
            throw new IllegalArgumentException("duplicate name is not allowed [" + name.value() + "]");
        }
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public RoundResult toResult() {
        return new RoundResult(cars.stream()
                .map(Car::toResult)
                .toList());
    }
}
