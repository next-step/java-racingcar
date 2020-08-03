package step3.factory;

import step3.domain.BasicForwardStrategy;
import step3.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> create(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(new BasicForwardStrategy()));
        }
        return cars;
    }
    private CarFactory() {
        throw new AssertionError();
    }

}
