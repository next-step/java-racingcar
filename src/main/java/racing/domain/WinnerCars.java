package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerCars {
    public static List<Car> findWinnerCars(List<Car> cars) {
        return getWinnerCars(cars, getWinnerPosition(cars));
    }

    private static List<Car> getWinnerCars(List<Car> cars, int winnerPosition) {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinnerPosition(winnerPosition)) {
                winnerCars.add(car);
            }
        }
        return winnerCars;
    }

    private static int getWinnerPosition(List<Car> cars) {
        int winnerPosition = 0;
        for (Car car : cars) {
            if (car.isWinnerPosition(winnerPosition)) {
                winnerPosition = car.getPosition();
            }
        }
        return winnerPosition;
    }
}
