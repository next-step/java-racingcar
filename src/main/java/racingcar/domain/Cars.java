package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(new Name(name)));
        }
    }

    // Constructor for UnitTest
    public Cars(Car... cars) {
        this.cars = Arrays.asList(cars);
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

    public Distance findMaxDistance() {
        Distance maxDistance = new Distance();
        for (Car car : cars) {
            maxDistance = returnMaxDistance(maxDistance, car);
        }
        return maxDistance;
    }

    private Distance returnMaxDistance(Distance maxDistance, Car car) {
        Distance carDistance = car.getDistance();
        if (carDistance.greaterThan(maxDistance)) {
            maxDistance = carDistance;
        }
        return maxDistance;
    }

}
