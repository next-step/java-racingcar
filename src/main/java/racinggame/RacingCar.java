package racinggame;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCar {
    private List<Car> cars;

    public RacingCar(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> racing() {
        for (Car car : cars) {
            car.move(createRandomNumber());
        }
        return cars;
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int max = cars.stream()
                .mapToInt(Car::getStatus)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getStatus() == max)
                .collect(Collectors.toList());
    }

    public static RacingCar of(List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new RacingCar(cars);
    }
}
