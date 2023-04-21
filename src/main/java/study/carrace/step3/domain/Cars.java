package study.carrace.step3.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final String LINE_BREAK = "\n";
    private final List<Car> cars;

    public Cars(List<String> carNames, MoveStrategy moveStrategy) {
        this.cars = cars(carNames, moveStrategy);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveOrStopCars() {
        cars.forEach(Car::moveOrStop);
    }

    public String carsPositionAt(int iteration) {
        StringBuilder carsPosition = new StringBuilder();
        cars.forEach(car -> carsPosition.append(car.positionAt(iteration)).append(LINE_BREAK));

        return carsPosition.toString();
    }

    public List<CarName> firstRankers() {
        return findCarNamesBy(maxNumberOfMove());
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
                .getAsLong();
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
