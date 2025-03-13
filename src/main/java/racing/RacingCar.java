package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public List<Car> createCars(int size) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
