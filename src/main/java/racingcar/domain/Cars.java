package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private final String DUPLICATE_CAR_NAME = "중복된 이름을 가진 자동차가 있습니다.";

    public Cars() {
        cars = new ArrayList<>();
    }

    public void add(Car car) {
        if (isDuplicate(car)) throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        cars.add(car);
    }

    private boolean isDuplicate(Car car) {
        return cars.stream().anyMatch(item -> item.getName().equals(car.getName()));
    }

    public int size() {
        return cars.size();
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }
}
