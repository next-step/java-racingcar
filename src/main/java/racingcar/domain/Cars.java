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
        List<Car> result = new ArrayList<>();
        for (Car car : this.elements) {
            boolean isMove = rule.move();
            result.add(car.move(isMove));
        }
        return new Cars(result);
    }

    public int size() {
        return this.elements.size();
    }

    public List<Car> getElements() {
        return Collections.unmodifiableList(this.elements);
    }

    public Winners getWinners() {
        int max = getMaxDistance();
        List<Car> cars = findByDistance(Distance.from(max));
        return Winners.valueOf(cars);
    }

    private int getMaxDistance() {
        return this.elements.stream()
                .map(Car::getDistance)
                .mapToInt(Distance::getValue)
                .max()
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
