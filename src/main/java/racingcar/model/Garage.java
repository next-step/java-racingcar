package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    public List<Car> cars  = new ArrayList<>();

    public List<Car> createCars(int number) {

        for (int i = 0; i < number; i++) {
             cars.add(new Car());
        }

        return cars;
    }
}
