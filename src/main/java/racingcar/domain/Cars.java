package racingcar.domain;

import racingcar.rules.Rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> elements;

    public Cars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.elements = new ArrayList<>(cars);
    }

    public static Cars of(final List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public Cars move(Rule rule) {
        return new Cars(this.elements.stream()
                .map(car -> car.move(rule.move()))
                .collect(Collectors.toList()));
    }

    public List<Car> getElements() {
        return Collections.unmodifiableList(this.elements);
    }

    public Winners getWinners() {
        Distance distance = getMaxDistance();
        List<Car> cars = findByDistance(distance);
        return Winners.valueOf(cars);
    }

    private Distance getMaxDistance() {
        return this.elements.stream()
                .map(Car::getDistance)
                .max(Distance::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<Car> findByDistance(Distance distance) {
        return this.elements.stream()
                .filter(car -> car.isEqualsDistance(distance))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(this.elements, cars1.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.elements);
    }
}
