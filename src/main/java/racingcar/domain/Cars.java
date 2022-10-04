package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = createCars(carNames);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    protected static List<Car> createCars(String[] carNames) {
        return Stream.of(carNames).map(Car::new).collect(Collectors.toList());
    }

    public void move(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public List<PlayResult> getPlayResults() {
        return cars.stream().map(Car::getPlayResult).collect(Collectors.toUnmodifiableList());
    }

}
