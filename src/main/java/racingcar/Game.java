package racingcar;

import java.util.List;

public class Game {
    private final List<Car> cars;

    public Game(final List<Car> car) {
        this.cars = car;
    }

    public void play() {
        for (Car car : cars) {
            car.move(RandomNumber.getNumber());
        }
    }

    public List<Car> getWinner() {
        cars.stream()
                .max(Car::compareTo)
                .ifPresent(max -> cars.removeIf(car -> car.compareTo(max) < 0));
        return cars;
    }
}
