package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.movable.MovableStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateCarExists(cars);
        this.cars = cars;
    }

    public void moveAll(MovableStrategy strategy) {
        for (Car car: cars) {
            car.run(strategy);
        }
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> filterWinners() {
        int max = calculateMax();
        return cars.stream()
            .filter(car -> car.distance() == max)
            .collect(Collectors.toList());
    }

    private void validateCarExists(List<Car> cars) {
        if (cars.size() == 0) {
            throw new IllegalArgumentException("[ERROR] 플레이어가 존재하지 않습니다.");
        }
    }

    private int calculateMax() {
        return cars.stream()
            .map(Car::distance)
            .max(Integer::compare)
            .orElseThrow(IllegalArgumentException::new);
    }
}
