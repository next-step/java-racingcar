package pobiRacingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> create(String s) {
        String[] names = s.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
