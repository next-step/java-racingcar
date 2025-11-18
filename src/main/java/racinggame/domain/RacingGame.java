package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public List<String> play() {
        List<String> roundResults = new ArrayList<>();
        for (Car car : cars) {
            roundResults.add(moveCar(car));
        }
        return roundResults;
    }

    private String moveCar(Car car) {
        return car.move(generateRandomNumber());
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public List<Car> getCars() {
        return cars;
    }
}
