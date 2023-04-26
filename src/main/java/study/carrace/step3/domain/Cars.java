package study.carrace.step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames, MoveStrategy moveStrategy) {
        this.cars = cars(carNames, moveStrategy);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars moveOrStopCars(int iteration) {
        List<Car> movedOrStoppedCars = cars.stream()
                .map(car -> car.moveOrStop(iteration))
                .collect(Collectors.toList());

        return new Cars(movedOrStoppedCars);
    }

    public List<CarName> firstRankers() {
        return findCarNamesBy(maxNumberOfMove());
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    private List<CarName> findCarNamesBy(long numberOfMove) {
        return cars.stream()
                .filter(car -> car.numberOfMove() == numberOfMove)
                .map(Car::carName)
                .collect(Collectors.toList());
    }

    private long maxNumberOfMove() {
        return cars.stream()
                .map(Car::numberOfMove)
                .mapToLong(l -> l)
                .max()
                .orElse(0L);
    }

    private List<Car> cars(List<String> carNames, MoveStrategy moveStrategy) {
        return carNames.stream()
                .map(carName -> new Car(carName, moveStrategy))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
