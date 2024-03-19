package game.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final NumberGenerator generator;
    private final List<Car> cars;

    public Game(NumberGenerator generator, List<String> names) {
        this.generator = generator;
        this.cars = generateCars(names);
    }

    private List<Car> generateCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
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

    public List<String> toStrings() {
        return this.cars.stream().map(Car::toString).collect(Collectors.toList());
    }
}
