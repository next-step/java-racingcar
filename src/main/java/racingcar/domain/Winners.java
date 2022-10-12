package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> cars) {
        this.winners = find(cars);
    }

    private List<Car> find(List<Car> cars) {
        int position = winnerPosition(cars);

        return cars.stream()
                .filter(car -> car.hasPosition(position))
                .collect(Collectors.toList());
    }

    private int winnerPosition(List<Car> cars) {
        int max = 0;
        for (Car car: cars) {
            max = car.getMaxPosition(max);
        }
        return max;
    }

    public List<String> getNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
