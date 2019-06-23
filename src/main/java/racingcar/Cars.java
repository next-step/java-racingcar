package racingcar;

import racingcar.Car;

import java.util.List;

public class Cars {

    final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

}
