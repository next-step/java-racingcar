package racingcar.domain;

import racingcar.rules.Rule;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<String> names) {
        this.cars = initialize(names);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public Winners getWinners() {
        int max = getMax();
        List<Name> names = findByDistance(Distance.valueOf(max))
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        return Winners.valueOf(names);
    }

    private int getMax() {
        return this.cars.stream()
                .map(Car::getDistance)
                .mapToInt(Distance::getValue)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<Car> findByDistance(Distance distance) {
        return cars.stream()
                .filter(car -> car.getDistance().equals(distance))
                .collect(Collectors.toList());
    }

    public Cars move(Rule rule) {
        for (Car car : this.cars) {
            car.move(rule.move());
        }
        return this;
    }

    private List<Car> initialize(final List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
        return names.stream()
                .map(Car::new)
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
