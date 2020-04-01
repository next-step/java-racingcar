package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.car.MovingStrategy;
import racingcar.domain.car.RandomMovingStrategy;
import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private static final String DELIMITER = ",";
    private static final int INT_ONE = 1;

    public RacingCarResponseDto run(RacingCarRequestDto racingCarRequestDto) {
        List<Cars> cars = executeRacingGameNumberOfTimes(racingCarRequestDto, new RandomMovingStrategy());
        Cars winners = findWinnerInRacingScores(cars);
        return new RacingCarResponseDto(cars, winners);
    }

    public List<Cars> executeRacingGameNumberOfTimes(RacingCarRequestDto racingCarRequestDto, MovingStrategy movingStrategy) {
        String[] racingCarNames = racingCarRequestDto.getRacingCarNames().split(DELIMITER);
        Cars cars = new Cars(racingCarNames);
        List<Cars> racingScores = new ArrayList<>();
        int numberOfTime = racingCarRequestDto.getNumberOfTime();

        for (int i = 0; i < numberOfTime; i++) {
            cars = executeRacingGame(cars, movingStrategy);
            racingScores.add(cars);
        }
        return racingScores;
    }

    private Cars executeRacingGame(Cars cars, MovingStrategy movingStrategy) {
        return cars.moveAll(movingStrategy);
    }

    public Cars findWinnerInRacingScores(List<Cars> cars) {
        Cars lastScore = findLastScore(cars);
        return lastScore.findWinners();
    }

    private Cars findLastScore(List<Cars> cars) {
        return cars.get(cars.size() - INT_ONE);
    }
}
