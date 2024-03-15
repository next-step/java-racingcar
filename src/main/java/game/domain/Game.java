package game.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final NumberGenerator generator;
    private final List<Car> cars;

    public Game(NumberGenerator generator, List<Car> cars) {
        this.generator = generator;
        this.cars = cars;
    }

    public void play() {
        for (Car car : cars) {
            int number = generator.getNumber();
            car.move(number);
        }
    }

    public List<Integer> getDistances() {
        return cars.stream().map(Car::getDistance).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
