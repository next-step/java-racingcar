package carrace.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> makeCarList(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        return carList;
    }

    public static List<Car> makeCarList(List<CarName> carNames) {
        List<Car> carList = new ArrayList<>();
        for (CarName carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }
}
