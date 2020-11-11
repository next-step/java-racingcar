package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.behavior.MovingStrategy;

public class RacingCars {
    private final List<Car> cars;
    private final MovingStrategy movingStrategy;
    private Round round;

    private RacingCars(List<Car> cars, MovingStrategy movingStrategy,Round round) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
        this.round = round;
    }

    public static RacingCars of(String[] nameOfCars, MovingStrategy movingStrategy,Round round) {
        List<Car> initCars = createCars(nameOfCars);
        return new RacingCars(initCars, movingStrategy,round);
    }

    private static List<Car> createCars(String[] nameOfCars) {
        return Arrays.stream(nameOfCars)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(RuntimeException::new);
    }

    public List<Car> getNamesOfWinnerCars() {
        int winnerPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.hasSamePosition(winnerPosition))
                .collect(Collectors.toList());
    }

    public void run() {
        cars.forEach(this::moveCar);
        round.nextRound();
    }

    private void moveCar(final Car car) {
        car.move(movingStrategy);
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
