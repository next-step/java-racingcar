package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static List<Car> carList;

    public static List<Car> makeCarList(int carCount) {
        carList = new ArrayList<>();
        for (int i = 1; i <= carCount; i++) {
            Car car = new Car();
            carList.add(car);
        }
        return carList;
    }
}
