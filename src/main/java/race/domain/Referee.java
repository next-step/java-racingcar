package race.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    private final List<Car> cars;

    public Referee(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinner() {
        return findWinnerHaving(max(cars));
    }

    private List<Car> findWinnerHaving(int max) {
        return cars.stream()
                .filter(car -> car.isWinner(max))
                .collect(Collectors.toUnmodifiableList());
    }

    private int max(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = car.maxComparedTo(max);
        }
        return max;
    }

}
