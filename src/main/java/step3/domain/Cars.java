package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars makeCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        List<Car> readOnlyCars = Collections.unmodifiableList(cars);
        return readOnlyCars;
    }


}
