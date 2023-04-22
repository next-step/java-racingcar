package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars create(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public void move(CarMovement carMovement) {
        for (Car car : cars) {
            car.move(carMovement.canMove());
        }
    }

    public List<Car> getWinner() {
        int largestPosition = cars.stream()
                .mapToInt(Car::getPositionValue)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPositionValue() == largestPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getAll() {
        return cars.stream().map(car -> new Car(car.getNameValue(), car.getPositionValue()))
                .collect(Collectors.toList());
    }
}
