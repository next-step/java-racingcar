package step3.utils;

import step3.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static final String CAR_NAME_DELIMETER = ",";

    public static List<Car> create(String carNames) {
        String[] names = carNames.split(CAR_NAME_DELIMETER);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
//            cars.add(new Car(name));
        }
        return cars;
    }
}
