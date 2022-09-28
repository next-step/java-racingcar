package step4;

import java.util.ArrayList;
import java.util.List;

public class PrepareRacing {

    static List<Car> prepareCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        int carCount = carNames.length;

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(carNames[i]));
        }

        return cars;
    }
}
