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

    public List<Car> getCarInfo() {
        return cars;
    }
}
