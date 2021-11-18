package racingcargamefinal.domain;

import racingcargamefinal.utils.RandomUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String carNames) {
        this(Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars move() {
        return new Cars(
                cars.stream().map(car ->
                        car.move(new MoveValue(RandomUtils.getRandomValue()))
                ).collect(Collectors.toList()));
    }

    public List<Car> findWinners() {
        return findWinners(findMaxPosition());
    }

    private Position findMaxPosition() {
        Position maxPosition = Position.ZERO;
        for (Car car : cars) {
            maxPosition = car.findMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<Car> findWinners(Position maxPosition) {
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
