package racing.domain;

import racing.generator.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarCollection {
    private final List<Car> cars;

    public CarCollection(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarCollection that = (CarCollection) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public CarCollection nextState(NumberGenerator numberGenerator) {
        return new CarCollection(
                this.cars.stream()
                        .map(car -> car.goForward(numberGenerator.generate()))
                        .collect(Collectors.toList())
                
        );
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
