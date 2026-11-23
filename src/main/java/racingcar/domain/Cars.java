package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNotEmpty(cars);
        validateUniqueNames(cars);
        this.cars = List.copyOf(cars);
    }

    private static void validateNotEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("at least one car is required");
        }
    }

    private static void validateUniqueNames(List<Car> cars) {
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

    public List<CarName> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
