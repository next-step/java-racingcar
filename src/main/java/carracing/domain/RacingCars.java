package carracing.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars;

    private RacingCars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(Objects.requireNonNull(cars));
    }

    public static RacingCars of(List<Car> carList) {
        return new RacingCars(carList);
    }

    public void move(Supplier<Number> numberSupplier) {
        cars.forEach(car -> car.move(numberSupplier.get()));
    }

    public List<Position> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public void forEach(Consumer<Car> action) {
        cars.forEach(action);
    }

    public List<Car> getWinners() {
        Position farthestPosition = Collections.max(cars, Comparator.comparing(Car::getPosition)).getPosition();
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getPosition))
                .get(farthestPosition);
    }
}
