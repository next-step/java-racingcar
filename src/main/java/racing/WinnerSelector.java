package racing;

import java.util.ArrayList;
import java.util.List;

public class WinnerSelector {
    
    public static List<Car> selectWinner(List<Car> cars) {
        Long maxPosition = getMaxPosition(cars);
        return getWinners(cars, maxPosition);
    }

    private static List<Car> getWinners(List<Car> cars, Long maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(maxPosition, winners, car);
        }
        return winners;
    }

    private static void addWinner(Long maxPosition, List<Car> winners, Car car) {
        if (car.getPosition() >= maxPosition) {
            winners.add(car);
        }
    }

    private static Long getMaxPosition(List<Car> cars) {
        Long maxPosition = 0L;
        for (Car car : cars) {
            maxPosition = (car.getPosition() > maxPosition) ? car.getPosition() : maxPosition;
        }
        return maxPosition;
    }
}
