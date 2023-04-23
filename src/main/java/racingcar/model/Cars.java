package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void setCarNumber(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }
    public List<Car> getCar() {
        return cars;
    }
}
