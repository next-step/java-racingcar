package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Racing {
    private static final int MAX_RANGE = 10;

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
            int randomNumber = makeRandomNumber();
            car.moveForward(randomNumber);
        }
        return cars;
    }

    private int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANGE);
    }

    public List<Car> getCarInfo() {
        return cars;
    }
}
