package racingcar;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public String getWinners() {
        return cars.stream()
                .filter(car -> car.isWinner(getWinnerPosition()))
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    int getWinnerPosition() {
        return cars.stream()
                .max(new WinnerCompare())
                .get()
                .getPosition();
    }
}
