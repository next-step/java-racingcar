package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> carList() {
        return cars;
    }

    public List<String> maxPositionCars() {
        return cars.stream()
                .filter(car -> car.forwardCnt() == (maxPosition()))
                .map(car -> car.carName())
                .collect(Collectors.toList());
    }

    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::forwardCnt)
                .max()
                .getAsInt();
    }
}
