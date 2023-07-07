package racing.domain;

import racing.generator.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarCollection {
    private static final int MOVING_RANGE_LOW = 4;
    private static final int MOVING_RANGE_HIGH = 9;
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
                        .map(car -> car.goForward(isMovable(numberGenerator.generate())))
                        .collect(Collectors.toList())
        );
    }

    public boolean isMovable(int value) {
        return MOVING_RANGE_LOW <= value && value <= MOVING_RANGE_HIGH;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
