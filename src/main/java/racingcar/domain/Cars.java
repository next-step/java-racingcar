package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void add(Car car) {
        if(isDuplicate(car)) throw new IllegalArgumentException("중복된 이름을 가진 자동차가 있습니다.");
        cars.add(car);
    }

    private boolean isDuplicate(Car car) {
        return cars.stream().filter(item -> item.getName().equals(car.getName())).count() > 0;
    }

    public int size() {
        return cars.size();
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public Car getCar(int i) {
        return cars.get(i);
    }

    public List<Car> getCars() {
        return cars;
    }
}
