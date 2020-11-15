package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.behavior.MovingStrategy;

public class RacingCars {
    private final List<Car> cars;
    private final MovingStrategy movingStrategy;
    private final int finalRound;
    private int round;

    private RacingCars(List<Car> cars, MovingStrategy movingStrategy, int finalRound) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
        this.finalRound = finalRound;
    }

    public static RacingCars of(String[] nameOfCars, MovingStrategy movingStrategy, int round) {
        List<Car> initCars = createCars(nameOfCars);
        return new RacingCars(initCars, movingStrategy, round);
    }

    private static List<Car> createCars(String[] nameOfCars) {
        return Arrays.stream(nameOfCars)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> progressRound() {
        run();
        return getCars();
    }

    int nextRound() {
        return round = round + 1;
    }

    public boolean isLastRound() {
        return finalRound == round;
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
        nextRound();
    }

    private void moveCar(final Car car) {
        car.move(movingStrategy);
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
