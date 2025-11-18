package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static List<Car> getWinners(List<Car> carList) {
        return getWinners(carList, getMaxDistance(carList));
    }

    private static List<Car> getWinners(List<Car> carList, int maxDistance) {
        List<Car> winners = new ArrayList<>();

        for(Car car : carList) {
            if(car.isMax(maxDistance)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getMaxDistance(List<Car> carList) {
        int max = 0;
        for(Car car : carList) {
            max = car.max(max);
        }
        return max;
    }
}
