package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerCalculator {
    public static List<Car> getWinners(List<Car> cars) {
        int maxTrace = getMaxTrace(cars);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getTrace() == maxTrace)
                winners.add(car);
        }
        return winners;
    }

    public static int getMaxTrace(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getTrace)
                .max()
                .orElse(0);
    }
}
