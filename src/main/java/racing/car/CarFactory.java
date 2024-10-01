package racing.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> makeCar(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            Car car = new Car(0);
            carList.add(car);
        }
        return carList;
    }
}
