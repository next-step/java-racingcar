package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> getFarthestCarNames() {
        Car farthestCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalStateException("경주에 참가한 자동차가 존재하지 않습니다."));

        return cars.stream()
                .filter(car -> car.isSamePosition(farthestCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}