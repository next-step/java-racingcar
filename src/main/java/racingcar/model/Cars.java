package racingcar.model;

import racingcar.model.wrapper.ForwardNumber;
import racingcar.util.NumberCreator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
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

    public void moveAll(NumberCreator numberCreator) {
        this.cars
                .forEach(car -> car.move(new ForwardNumber(numberCreator.number(car))));
    }

    public List<String> currentStatuses() {
        return this.cars
                .stream()
                .map(Car::currentStatus)
                .collect(Collectors.toList());
    }
}
