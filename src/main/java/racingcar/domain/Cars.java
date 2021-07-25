package racingcar.domain;

import racingcar.rules.Rule;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<String> names) {
        this.cars = initialize(names);
    }

    public int size() {
        return cars.size();
    }

    public Cars move(Rule rule) {
        for (Car car : this.cars) {
            car.move(rule.move());
        }
        return this;
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> initialize(final List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
