package core;

import java.util.ArrayList;
import java.util.List;

public class TestObjectGenerator {
    public static Car generateCar(String carName, int position) {
        Car car = Car.create(carName);
        for (int i = 0; i < position; i++) {
            car = car.move(Car.BASE_MOVE_VALUE);
        }
        return car;
    }

    public static Cars generateCars(Car car, int count) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            carList.add(car);
        }

        return Cars.fromCars(carList);
    }
}
