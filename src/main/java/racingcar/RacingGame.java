package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static final String DELIMITER = ",";
    public static final int DEFAULT_MAX_POSITION = 0;

    private final MoveStrategy moveStrategy;

    public RacingGame(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public List<Car> createCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] names = carNames.split(DELIMITER);
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public RaceResult race(List<Car> cars, int attemptCount) {
        List<AttemptResult> attemptResults = new ArrayList<>();
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            AttemptResult attemptResult = runAttempt(cars);
            attemptResults.add(attemptResult);
        }
        return new RaceResult(attemptResults);
    }

    private AttemptResult runAttempt(List<Car> cars) {
        List<Car> positions = new ArrayList<>();
        for (Car car : cars) {
            car.move(moveStrategy);
            positions.add(new Car(car.getPosition(), car.getName()));
        }
        return new AttemptResult(positions);
    }

    public List<Car> getWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(DEFAULT_MAX_POSITION);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
