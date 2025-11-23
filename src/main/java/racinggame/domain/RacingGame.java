package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import static racinggame.domain.CarFactory.createCars;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public RacingGame(String names) {
        this(createCars(names));
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

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            addWinners(car, maxPosition, winners);
        }
        return winners;
    }

    private void addWinners(Car car, int maxPosition, List<String> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    @Override
    public String toString() {
        return "RacingGame{" + "cars=" + cars + '}';
    }
}
