package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerCalculator {
    public static List<Car> getWinners(List<Car> cars) {
        Trace maxTrace = getMaxTrace(cars);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getTrace().equals(maxTrace))
                winners.add(car);
        }
        return winners;
    }

    public static Trace getMaxTrace(List<Car> cars) {
        Trace maxTrace = new Trace();
        for (Car car : cars) {
            maxTrace = car.getMaxTrace(maxTrace);
        }
        return maxTrace;
    }
}
