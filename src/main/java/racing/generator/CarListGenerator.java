package racing.generator;

import racing.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarListGenerator {
    public static List<Car> generateCarList(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }
}