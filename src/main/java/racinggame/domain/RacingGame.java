package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static List<Car> cars = new ArrayList<>();

    public RacingGame(String names) {
        this(createCars(names));

    }

    public RacingGame(List<Car> cars) {
        RacingGame.cars = cars;
    }

    private static List<Car> createCars(String names) {
        String[] split = names.split(",");

        for (String s : split) {
            cars.add(new Car(s.trim()));
        }

        return cars;
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

    @Override
    public String toString() {
        return "RacingGame{" +
                "cars=" + cars +
                '}';
    }

    public List<Car> getCars() {
        return cars;
    }
}
