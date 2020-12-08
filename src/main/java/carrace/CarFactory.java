package carrace;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> makeCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        return carList;
    }
}
