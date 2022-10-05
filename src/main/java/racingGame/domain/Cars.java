package racingGame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
    public List<String> findCoWinner() {
        return cars.stream()
                .filter(car -> car.getTraceSize() == getMaxPosition())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private long getMaxPosition() {
        return getMaxCar().getTraceSize();
    }

    private Car getMaxCar() {
        return Collections.max(cars);
    }

}
