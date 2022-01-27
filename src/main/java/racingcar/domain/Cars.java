package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.movable.MovableStrategy;

public class Cars {

    private static final String NAME_SPLITTER = ",";

    private final List<Car> cars;

    public Cars(final String cars) {
        this(Arrays.stream(cars.split(NAME_SPLITTER))
            .map(String::trim)
            .map(Car::new)
            .collect(Collectors.toList())
        );
    }

    public Cars(final List<Car> cars) {
        validateCarExists(cars);
        this.cars = cars;
    }

    public void moveAll(final MovableStrategy strategy) {
        for (Car car: cars) {
            car.run(strategy);
        }
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinnerList() {
        int max = calculateMax();
        return cars.stream()
            .filter(car -> car.isDistance(max))
            .collect(Collectors.toList());
    }

    private void validateCarExists(final List<Car> cars) {
        if (cars.size() == 0) {
            throw new IllegalArgumentException("[ERROR] 플레이어가 존재하지 않습니다.");
        }
    }

    private int calculateMax() {
        return cars.stream()
            .mapToInt(Car::distance)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 예외가 발생하였습니다 : max 값이 존재하지 않습니다."));
    }
}
