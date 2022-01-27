package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<Car> winnerCars;

    public Winners(List<Car> cars) {
        this.winnerCars = filterWinners(cars);
    }

    private List<Car> filterWinners(List<Car> cars) {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max().orElseThrow(IllegalStateException::new);

        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .collect(Collectors.toList());
    }

    public List<Car> getWinnerCars() {
        return winnerCars;
    }
}
