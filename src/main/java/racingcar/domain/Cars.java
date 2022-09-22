package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return deepCopy(cars);
    }

    private List<Car> deepCopy(List<Car> src) {
        List<Car> dest = new ArrayList<>();

        for (Car car : src) {
            dest.add(Car.of(car));
        }

        return dest;
    }

    public int size() {
        return cars.size();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }
}
