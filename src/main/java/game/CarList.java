package game;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private static final String SPERATOR = ",";
    public static List<Car> makeCars(String data) {
        String[] names = data.split(SPERATOR);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
