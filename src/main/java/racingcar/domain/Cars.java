package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final String DEFAULT_DELIMITER = ",";
    private final List<Car> cars = new ArrayList<>();

    public Cars(String names) {
        for (String name : this.split(names)) {
            this.cars.add(Car.create(name));
        }
    }

    private String[] split(String names) {
        return names.split(DEFAULT_DELIMITER);
    }

    public void race(NumberGenerator generator) {
        for (Car car : cars) {
            int number = generator.generator();
            car.move(number);
        }
    }

    public List<Car> cars() {
        return this.cars;
    }

    public List<Position> positions() {
        List<Position> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(car.position());
        }

        return positions;
    }
}
