package car.util;

import car.entity.Car;

import java.util.List;

public class PrintGameStatus {
    public static void carsStatus(List<Car> cars) {
        for (Car car : cars) {
            car.printStatus();
        }
        System.out.println();
    }
}
