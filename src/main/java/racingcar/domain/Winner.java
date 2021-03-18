package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private List<String> winner;

    public Winner(List<Car> cars) {
        Car winCar = getWinnerMax(cars);
        winner = cars.stream()
                .filter(car -> car.equals(winCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car getWinnerMax(List<Car> cars) {
        return cars.stream().max(Car::compareTo).get();
    }

    public List<String> getWinner() {
        return winner;
    }
}
