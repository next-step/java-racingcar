package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.car.Car;
import racingcar.domain.car.MovingStrategy;
import racingcar.dto.RacingCarRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGameService {
    private static final String DELIMITER = ",";
    private static final int INT_ZERO = 0;
    private static final int INT_ONE = 1;

    public List<Cars> executeRacingGameNumberOfTimes(RacingCarRequestDto racingCarRequestDto, MovingStrategy movingStrategy) {
        String[] racingCarNames = racingCarRequestDto.getRacingCarNames().split(DELIMITER);
        Cars cars = createCars(racingCarNames);
        List<Cars> racingScores = new ArrayList<>();
        int numberOfTime = racingCarRequestDto.getNumberOfTime();

        for (int i = 0; i < numberOfTime; i++) {
            racingScores.add(executeRacingGame(cars, movingStrategy));
        }

        return racingScores;
    }

    private Cars createCars(String[] names) {
        if (Objects.isNull(names) || names.length <= INT_ZERO) {
            throw new IllegalArgumentException("자동차의 개수는 1보다 커야 합니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }

    private Cars executeRacingGame(Cars cars, MovingStrategy movingStrategy) {
        return cars.moveAll(movingStrategy);
    }

    public List<Car> findWinnerInRacingScores(List<Cars> cars) {
        Cars lastScore = findLastScore(cars);
        return lastScore.findWinners();
    }

    private Cars findLastScore(List<Cars> cars) {
        return cars.get(cars.size() - INT_ONE);
    }
}
