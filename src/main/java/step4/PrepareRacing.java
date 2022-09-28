package step4;

import java.util.ArrayList;
import java.util.List;

public class PrepareRacing {

    static List<Car> prepareCar(int carCount) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
