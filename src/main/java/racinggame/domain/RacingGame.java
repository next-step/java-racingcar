package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(String names) {
        splitCarName(names);
    }

    public RacingGame(int number) {
        addCars(number);
    }

    private void addCars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    private void splitCarName(String name) {
        String[] split = name.split(",");

        for (String s : split) {
            cars.add(new Car(s.trim()));
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
