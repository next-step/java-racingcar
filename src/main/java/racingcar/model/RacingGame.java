package racingcar.model;

import racingcar.message.Message;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;

    private RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingGame createRacingGame(List<String> names) {
        List<Car> cars = createCars(names);

        return new RacingGame(cars);
    }

    public static RacingGame ofCars(List<Car> cars) {
        return new RacingGame(cars);
    }

    private static List<Car> createCars(List<String> names) {
        return names.stream()
                .map(name -> new Car(new CarName(name)))
                .collect(Collectors.toList());
    }

    public boolean hasCarCount(int expectedCount) {
        return cars.size() == expectedCount;
    }

    public boolean areAllCarsAtPosition(Position position) {
        return cars.stream().allMatch(car -> car.isAtPosition(position));
    }

    public RacingGame race(int attemptCount) {
        OutputView.print(Message.RESULT_MESSAGE);

        List<Car> updatedCars = getCars(attemptCount);

        return new RacingGame(updatedCars);
    }

    private List<Car> getCars(int attemptCount) {
        List<Car> updatedCars = cars;

        updatedCars = executeRace(attemptCount, updatedCars);
        return updatedCars;
    }

    private List<Car> executeRace(int attemptCount, List<Car> updatedCars) {
        for (int i = 0; i < attemptCount; i++) {
            updatedCars = move(updatedCars);
            OutputView.print("");
        }
        return updatedCars;
    }

    private List<Car> move(List<Car> currentCars) {
        List<Car> movedCars = moveCars(currentCars);

        movedCars.forEach(System.out::println);

        return movedCars;
    }

    private List<Car> moveCars(List<Car> currentCars) {
        return currentCars.stream()
                .map(car -> car.move(RandomNumberGenerator.generateNumber()))
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.isAtPosition(new Position(maxPosition)))
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
