package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameJudge {

    public List<Car> getWinners(List<Car> cars) {
        int maxMovedDistance = getMaxMovedDistanceOfCars(cars);

        return cars.stream()
                .filter(car -> maxMovedDistance == car.getMovedDistance())
                .collect(Collectors.toList());
    }

    private int getMaxMovedDistanceOfCars(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .getAsInt();
    }
}
