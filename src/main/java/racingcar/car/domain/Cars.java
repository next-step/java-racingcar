package racingcar.car.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> list;

    public Cars(final String[] names) {
        list = Arrays.stream(names)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public Cars(final List<Car> cars) {
        this.list = cars;
    }

    public void move(MoveStrategy moveStrategy) {
        for (Car car : list) {
            if (moveStrategy.isMovable())
                car.move();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition(list);

        return list.stream()
            .filter(car -> car.matchPosition(maxPosition))
            .collect(Collectors.toList());
    }

    private int getMaxPosition(final List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(list);
    }
}
