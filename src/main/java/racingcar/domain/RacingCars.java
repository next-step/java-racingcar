package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.behavior.MovingStrategy;

public class RacingCars {

    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    private RacingCars(List<Car> cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public static RacingCars of(String[] nameOfCars, MovingStrategy movingStrategy) {
        List<Car> initCars = createCars(nameOfCars);
        return new RacingCars(initCars, movingStrategy);
    }

    private static List<Car> createCars(String[] nameOfCars) {
        return Arrays.stream(nameOfCars)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(RuntimeException::new);
    }

    public List<Car> getWinnerCars() {
        int winnerPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.hasSamePosition(winnerPosition))
                .collect(Collectors.toList());
    }

    public void run() {
        cars.forEach(this::moveCar);
    }

    private void moveCar(final Car car) {
        car.move(movingStrategy);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}