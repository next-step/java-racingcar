package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final MoveStrategy moveStrategy;

    public RacingGame(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public RaceResult race(List<Car> cars, int attemptCount) {
        RaceResult raceResult = new RaceResult(attemptCount);
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            AttemptResult attemptResult = runAttempt(cars);
            raceResult.addAttemptResult(attemptResult, attempt);
        }
        return raceResult;
    }

    private AttemptResult runAttempt(List<Car> cars) {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            car.move(moveStrategy);
            positions.add(car.getPosition());
        }
        return new AttemptResult(positions);
    }

    public List<Car> createCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] names = carNames.split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
