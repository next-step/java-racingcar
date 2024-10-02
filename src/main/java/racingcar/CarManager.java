package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    public static List<Car> createCarsByCnt(List<String> namesOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < namesOfCar.size(); i++) {
            cars.add(new Car(namesOfCar.get(i)));
        }
        return cars;
    }
}