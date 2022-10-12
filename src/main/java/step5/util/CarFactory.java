package step5.util;

import java.util.ArrayList;
import java.util.List;
import step5.domain.Car;
import step5.domain.CarName;

public class CarFactory {

    private CarFactory(){
    }

    public static List<Car> createCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        int carCount = carNames.length;

        for (int i = 0; i < carCount; i++) {
            CarName carName = new CarName(carNames[i]);
            cars.add(new Car(carName));
        }

        return cars;
    }
}
