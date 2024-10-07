package racingcar.domain;

import racingcar.dto.AttemptResult;
import racingcar.dto.RaceResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static final int DEFAULT_MAX_POSITION = 0;

    private final MoveStrategy moveStrategy;
    private final CarCreationStrategy carCreationStrategy;

    public RacingGame(MoveStrategy moveStrategy, CarCreationStrategy carCreationStrategy) {
        this.moveStrategy = moveStrategy;
        this.carCreationStrategy = carCreationStrategy;
    }

    public RaceResult play(String carNames, int attemptCount) {
        List<Car> cars = create(carNames);
        return race(attemptCount, cars);
    }

    private List<Car> create(String names) {
        return carCreationStrategy.create(names);
    }

    private RaceResult race(int attemptCount, List<Car> cars) {
        List<AttemptResult> attemptResults = getAttemptResults(attemptCount, cars);
        List<String> winners = getWinners(cars);
        return new RaceResult(attemptResults, winners);
    }

    private List<AttemptResult> getAttemptResults(int attemptCount, List<Car> cars) {
        List<AttemptResult> attemptResults = new ArrayList<>();
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            AttemptResult attemptResult = getAttemptResult(cars);
            attemptResults.add(attemptResult);
        }
        return attemptResults;
    }

    private AttemptResult getAttemptResult(List<Car> cars) {
        List<Car> positions = new ArrayList<>();
        for (Car car : cars) {
            car.move(moveStrategy);
            positions.add(new Car(car.getPosition(), car.getName()));
        }
        return new AttemptResult(positions);
    }

    private List<String> getWinners(List<Car> cars) {
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
