package carracing.domain;

import java.util.*;
import java.util.function.Consumer;
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

    public void forEach(Consumer<Car> action) {
        cars.forEach(action);
    }

    public Map<Position, List<Car>> groupByPosition() {
        Map<Position, List<Car>> carsGroupByPosition = new HashMap<>();
        for (Car car : cars) {
            List<Car> cars = carsGroupByPosition.getOrDefault(car.getPosition(), new ArrayList<>());
            cars.add(car);
            carsGroupByPosition.put(car.getPosition(), cars);
        }
        return carsGroupByPosition;
    }
}
