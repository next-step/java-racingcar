package racingcar.model.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String MAX_DRIVE_LENGTH = "MAX 값을 구할 수 없습니다. 비교할 수 있는 정수값인지 확인하세요";
    private final List<Car> cars;

    public Cars(final List<String> carsName) {
        this.cars = createCars(carsName);
    }

    private List<Car> createCars(final List<String> carsName) {
        return carsName.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public void drive(final CarMoveBehavior carMoveBehavior) {
        cars.forEach(car -> moveCar(car, carMoveBehavior));
    }

    private void moveCar(final Car car, final CarMoveBehavior carMoveBehavior) {
        if (carMoveBehavior.moveBehavior()) {
            car.moveForward();
        }
    }

    public List<Car> doMaxCar(final int max) {
        return cars.stream()
            .filter(car -> car.isMax(max))
            .collect(Collectors.toList());
    }

    public int findMaxStepCars() {
        return cars.stream()
            .mapToInt(Car::getStep)
            .max()
            .orElseThrow(() -> new IllegalArgumentException(MAX_DRIVE_LENGTH));
    }
}

