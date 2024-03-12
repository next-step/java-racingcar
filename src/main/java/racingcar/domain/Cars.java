package racingcar.domain;

import racingcar.Name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(new Name(name)));
        }
    }

    public Cars(Cars cars) {
        this.cars = new ArrayList<>(cars.cars);
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    public int size() {
        return cars.size();
    }

    public void move(CarMoveStrategy moveStrategy) {
        for (Car car : this.cars) {
            car.move(moveStrategy);
        }
    }

}
