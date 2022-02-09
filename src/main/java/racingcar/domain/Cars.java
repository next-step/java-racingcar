package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.movable.MovableStrategy;
import racingcar.utils.Parser;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromString(final String carNames) {
        return new Cars(Parser
            .parseCarNames(carNames)
            .stream()
            .map(Car::new)
            .collect(Collectors.toList()));
    }

    public static Cars fromCarList(final List<Car> cars) {
        return new Cars(cars);
    }

    public void moveAll(MovableStrategy strategy) {
        for (Car car : cars) {
            car.run(strategy);
        }
    }

    public List<Car> filterWinners() {
        int max = calculateMax();
        return cars.stream().filter(car -> car.getDistance() == max).collect(Collectors.toList());
    }

    public List<Car> get() {
        return cars;
    }

    private int calculateMax() {
        return cars.stream().mapToInt(Car::getDistance).max()
            .orElseThrow(() -> new IllegalArgumentException("최대 이동 거리 값을 구할 수 없습니다."));
    }
}
