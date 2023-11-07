package racingcar.domain;

import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars(int carCount) {
        this.cars = new ArrayList<>();
        addCar(carCount);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }

    public void addCar(int input) {
        for (int i = 0; i < input; i++) {
            cars.add(new Car());
        }
    }
}
