package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.MovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<Car> findWinners() {
        int maxPosition = calculateMaxPosition();
        return cars.stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int calculateMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public Cars moveAll(MovingStrategy movingStrategy) {
        List<Car> executedCars = new ArrayList<>();

        for (Car car : cars) {
            car.move(movingStrategy);
            executedCars.add(car.clone());
        }

        return new Cars(executedCars);
    }
}
