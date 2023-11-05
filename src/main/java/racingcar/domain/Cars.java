package racingcar.domain;

import java.util.*;

public class Cars {

    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return cars;
    }

    public void addCar(int input) {
        for(int i=0; i < input; i++) {
            cars.add(new Car());
        }
    }
}
