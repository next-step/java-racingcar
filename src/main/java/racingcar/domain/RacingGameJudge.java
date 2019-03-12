package racingcar.domain;

import racingcar.vo.RacingResultOfRound;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameJudge {

    public List<Car> getWinners(RacingResultOfRound racingResultOfRound) {
        List<Car> cars = racingResultOfRound.getCarsOfRound();

        int maxMovedDistance = getMaxMovedDistanceFromCars(cars);

        return cars.stream()
                .filter(car -> maxMovedDistance == car.getMovedDistance())
                .collect(Collectors.toList());
    }

    private int getMaxMovedDistanceFromCars(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .getAsInt();
    }
}
