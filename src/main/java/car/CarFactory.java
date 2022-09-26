package car;

import java.util.ArrayList;
import java.util.List;

public interface CarFactory {
    default List<Car> generateCar(Integer num) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            cars.add(generateCar());
        }

        return cars;
    }
    Car generateCar();
}
