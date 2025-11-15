package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static List<Car> getWinners(List<Car> carList) {
        List<Car> winners = new ArrayList<>();
        int max = getMaxDistance(carList);

        for(Car car : carList) {
            if(car.isMax(max)) {
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
