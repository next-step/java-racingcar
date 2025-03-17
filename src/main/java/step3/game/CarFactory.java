package step3.game;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> createCars(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
