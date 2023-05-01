package car_racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {

    public static List<Car> getWinner(List<Car> cars) {
        List<Integer> carMoveCounts = getCarMoveCounts(cars);
        int maxCount = Collections.max(carMoveCounts);
        return getWinCars(maxCount, cars);
    }

    private static List<Integer> getCarMoveCounts(List<Car> cars) {
        List<Integer> carMoveCounts = new ArrayList<>();
        for (Car car : cars) {
            carMoveCounts.add(car.getPosition().getPosition());
        }
        return carMoveCounts;
    }

    private static List<Car> getWinCars(int maxCount, List<Car> cars) {
        List<Car> winCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition().isSame(maxCount)) {
                winCars.add(car);
            }
        }
        return winCars;
    }

}
