package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        cars.forEach((Car car) -> car.run(new RandomMoveStrategy()));
    }

    public List<Car> getWinners() {
        Car winner = Collections.max(cars);
        return cars.stream()
                .filter((Car car) -> car.isSamePosition(winner))
                .collect(Collectors.toList());
    }

    public List<Car> getList() {
        return Collections.unmodifiableList(cars);
    }
}
