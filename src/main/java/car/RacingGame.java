package car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static List<Car> createCarList(int numberOfCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }

}
