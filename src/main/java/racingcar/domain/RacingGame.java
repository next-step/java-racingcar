package racingcar.domain;

import racingcar.dto.AttemptResult;
import racingcar.dto.RaceResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static final String DELIMITER = ",";
    public static final int DEFAULT_MAX_POSITION = 0;

    private final MoveStrategy moveStrategy;
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(String carNames, MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        createCars(carNames);
    }

    private void createCars(String carNames) {
        String[] names = carNames.split(DELIMITER);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public RaceResult race(int attemptCount) {
        List<AttemptResult> attemptResults = new ArrayList<>();
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            AttemptResult attemptResult = runAttempt(cars);
            attemptResults.add(attemptResult);
        }

        List<String> winners = getWinners();

        return new RaceResult(attemptResults, winners);
    }

    private AttemptResult runAttempt(List<Car> cars) {
        List<Car> positions = new ArrayList<>();
        for (Car car : cars) {
            car.move(moveStrategy);
            positions.add(new Car(car.getPosition(), car.getName()));
        }
        return new AttemptResult(positions);
    }

    private List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_MAX_POSITION);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
