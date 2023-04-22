package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnersUtil {
    public static int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.position(), maxPosition);
        }
        return maxPosition;
    }

    public static List<String> determineWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            determineWinner(maxPosition, winners, car);
        }
        return winners;
    }

    private static void determineWinner(int maxPosition, List<String> winners, Car car) {
        if (car.isWinner(maxPosition)) {
            winners.add(car.name());
        }
    }
}
