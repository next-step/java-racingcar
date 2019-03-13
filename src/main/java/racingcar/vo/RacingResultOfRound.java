package racingcar.vo;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResultOfRound {
    private final List<Car> carsOfRound;
    private final int round;

    public RacingResultOfRound(List<Car> carsOfRound, int round) {
        this.carsOfRound = carsOfRound;
        this.round = round;
    }

    public List<Car> getCarsOfRound() {
        return Collections.unmodifiableList(carsOfRound);
    }

    public int getRound() {
        return round;
    }

    public List<Car> getWinners() {
        int maxMovedDistance = getMaxMovedDistance();

        return this.carsOfRound.stream()
                .filter(car -> maxMovedDistance == car.getMovedDistance())
                .collect(Collectors.toList());
    }

    int getMaxMovedDistance() {
        return this.carsOfRound.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .getAsInt();
    }
}
