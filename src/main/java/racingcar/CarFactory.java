package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Car> createCar(String[] carList) {
        List<Car> carArrayList = new ArrayList<>();

        for (String i : carList) {
            Car car = new Car(i, 0);
            carArrayList.add(car);
        }
        return carArrayList;
    }
}
