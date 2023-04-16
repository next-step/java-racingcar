package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            this.cars.add(Car.create(name));
        }
    }

    public Cars(Car... cars) {
        Collections.addAll(this.cars, cars);
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

    public Position highPosition() {
        Position position = Position.init();
        for (Car car : cars) {
            position = this.highPosition(position, car.position());
        }

        return position;
    }

    private Position highPosition(Position highPosition, Position position) {
        if (position.compareTo(highPosition) > 0) {
            return position;
        }

        return highPosition;
    }
}
