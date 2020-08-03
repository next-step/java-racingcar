package step3.factory;

import step3.domain.BasicForwardStrategy;
import step3.domain.Car;
import step3.domain.ForwardStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private static ForwardStrategy forwardStrategy;

    static {
        forwardStrategy = new BasicForwardStrategy();
    }

    public static List<Car> create(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(forwardStrategy));
        }
        return cars;
    }

    private CarFactory() {
        throw new AssertionError();
    }

}
