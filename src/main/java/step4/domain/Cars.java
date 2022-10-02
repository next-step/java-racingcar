package step4.domain;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final Set<Car> cars;

    public Cars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<String> getWinningCars() {
        int maxStep = this.cars.stream()
                .mapToInt(car -> car.getCarProperty().getStep())
                .max()
                .orElseThrow(NoSuchElementException::new);

        return this.cars.stream()
                .filter(car -> car.getCarProperty().getStep() == maxStep)
                .map(car -> car.getCarProperty().getName())
                .collect(Collectors.toSet());
    }

    public Set<Car> getCarSet() {
        return this.cars;
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
