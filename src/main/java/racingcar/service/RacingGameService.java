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
        List<Car> cars = createCars(racingCarNames);
        List<Cars> racingScores = new ArrayList<>();

        for (int i = 0; i < racingCarRequestDto.getNumberOfTime(); i++) {
            racingScores.add(executeRacingGame(cars, movingStrategy));
        }

        return racingScores;
    }

    private List<Car> createCars(String[] names) {
        if (Objects.isNull(names) || names.length <= INT_ZERO) {
            throw new IllegalArgumentException("자동차의 개수는 1보다 커야 합니다.");
        }

        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private Cars executeRacingGame(List<Car> cars, MovingStrategy movingStrategy) {
        List<Car> executedCars = new ArrayList<>();

        for (Car car : cars) {
            car.move(movingStrategy);
            executedCars.add(car.clone());
        }

        return new Cars(executedCars);
    }

    public List<Car> findWinnerInRacingScores(List<Cars> cars) {
        Cars lastScore = findLastScore(cars);
        return lastScore.findWinners();
    }

    private Cars findLastScore(List<Cars> cars) {
        return cars.get(cars.size() - INT_ONE);
    }
}
