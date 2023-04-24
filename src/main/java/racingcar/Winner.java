package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public static List<Car> getWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int max = getHighDistance(cars);
        for (Car car : cars) {
            if(car.isWinner(max)){
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getHighDistance(List<Car> cars) {
        int max = 1;
        for (Car car : cars) {
            max = car.max(max);
        }
        return max;
    }
}
