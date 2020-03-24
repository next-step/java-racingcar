package racingcar.service;

import racingcar.domain.RacingScore;
import racingcar.domain.car.Car;
import racingcar.domain.car.MovingStrategy;
import racingcar.domain.car.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGameService {
    private static final int INT_ZERO = 0;
    private static final int INT_ONE = 1;

    private List<Car> cars = new ArrayList<>();

    private void createCars(String[] names) {
        if (Objects.isNull(names) || names.length <= INT_ZERO) {
            throw new IllegalArgumentException("자동차의 개수는 1보다 커야 합니다.");
        }
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private RacingScore executeRacingGame(MovingStrategy movingStrategy) {
        List<Car> executedCars = new ArrayList<>();
        for (Car car : cars) {
            car.move(movingStrategy);
            executedCars.add(car.clone());
        }

        return new RacingScore(executedCars);
    }

    public List<RacingScore> executeRacingGameNumberOfTimes(int numberOfTime, MovingStrategy movingStrategy) {
        List<RacingScore> racingScores = new ArrayList<>();
        for (int i = 0; i < numberOfTime; i++) {
            racingScores.add(executeRacingGame(movingStrategy));
        }
        return racingScores;
    }

    public List<Car> findWinnerInRacingScores(List<RacingScore> racingScores) {
        RacingScore lastRacingScore = racingScores.get(racingScores.size() - INT_ONE);
        return lastRacingScore.findWinners();
    }

    public void createRacingCar(String[] racingCarNames) {
        createCars(racingCarNames);
    }
}
