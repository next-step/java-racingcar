package carracing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(Objects.requireNonNull(cars));
    }

    public static Cars of(List<Car> carList) {
        return new Cars(carList);
    }

    public void move(Supplier<Number> numberSupplier) {
        cars.forEach(car -> car.move(numberSupplier.get()));
    }

    public List<Position> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
