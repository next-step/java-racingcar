package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Racing {
    private static final int MAX_RANGE = 10;
    private static final int FORWARD_NUMBER = 4;
    private static final Random random = new Random();

    private List<Car> cars;

    public Racing() {
    }

    public void registerCarsByName(List<String> carNames) {
        this.cars = carNames.stream()
            .map(Car::of)
            .collect(Collectors.toList());
    }

    public void registerCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> race() {
        for (Car car : cars) {
            moveCar(car, isMovable(generateRandomNumber()));
        }
        return cars;
    }

    public void moveCar(Car car, boolean isMovable) {
        if (isMovable) {
            car.moveForward();
        }
    }

    public boolean isMovable(int moveNumber) {
        return moveNumber >= FORWARD_NUMBER;
    }

    private int generateRandomNumber() {
        return random.nextInt(MAX_RANGE);
    }

    public List<String> getWinnersName() {
        final int maxLocation = findMaxLocation();
        final List<Car> winners = findWinners(maxLocation);
        return winners.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private List<Car> findWinners(final int maxLocation) {
        return cars.stream()
            .filter(car -> car.getLocation() == maxLocation)
            .collect(Collectors.toList());
    }

    private int findMaxLocation() {
        return cars.stream()
            .mapToInt(Car::getLocation)
            .max().getAsInt();
    }

    public List<Car> getCarInfo() {
        return cars;
    }
}
