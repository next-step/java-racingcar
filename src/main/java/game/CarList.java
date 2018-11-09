package game;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    public static List<Car> makeCars(String data) {
        String[] names = data.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
