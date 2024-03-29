package racinggame.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private static final int MAX_BOUND = 10;

    private final List<Car> cars;

    public Cars(String carNames) {
        this(carNames.split(","));
    }

    public Cars(String[] carNames) {
        this(toCars(carNames));
    }

    private static List<Car> toCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        Random random = new Random();
        for (Car car : cars) {
            car.move(new ComputerTimeBasedMovingStrategy());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinners() {
        return findWinners(maxPosition());
    }

    private List<Car> findWinners(CarNumber maxPosition) {
        return cars.stream()
                .filter(it -> it.isMatch(maxPosition))
                .collect(Collectors.toList());
    }

    private CarNumber maxPosition() {
        CarNumber maxPosition = new CarNumber();
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }
}
