package car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> generateCar(int num) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
