package study.racingcar.domain;

import study.racingcar.strategy.AwardsStrategy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wyparks2@gmail.com on 2019-06-19
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class Awards {
    private final AwardsStrategy awardsStrategy;

    public Awards(AwardsStrategy awardsStrategy) {
        this.awardsStrategy = awardsStrategy;
    }

    public Cars award(CarsRacingLog lastCarsRacingLog) {
        final int maxPosition = getMaxPosition(lastCarsRacingLog);

        return getWinners(lastCarsRacingLog, maxPosition);
    }

    private int getMaxPosition(CarsRacingLog carsRacingLog) {
        return carsRacingLog.getCarRacingLogs().stream()
                .map(CarRacingLog::getPosition)
                .max(Integer::compare)
                .orElse(0);
    }

    private Cars getWinners(CarsRacingLog carsRacingLog, int maxPosition) {
        List<Car> cars = carsRacingLog.getCarRacingLogs().stream()
                .filter(carRacingLog -> awardsStrategy.isWinner(maxPosition, carRacingLog.getPosition()))
                .map(CarRacingLog::getCar)
                .collect(Collectors.toList());

        return new Cars(cars);
    }
}
