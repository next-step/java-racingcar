package carracing;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public static List<Car> findWinner(List<Car> cars) {
        return findWinner(cars, getMaxPosition(cars));
    }

    private static List<Car> findWinner(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)){
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

}
