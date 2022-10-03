package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = createCars(carNames);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    protected static List<Car> createCars(String[] carNames) {
        final List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void move(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<PlayResult> getPlayResults() {
        return cars.stream().map(Car::getPlayResult).collect(Collectors.toUnmodifiableList());
    }

}
