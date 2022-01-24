package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final String DELIMITER = ", ";

    public static void print(List<Car> cars) {
        List<String> winners = findWinner(cars);
        String winnerList = String.join(DELIMITER, winners);
        System.out.println("최종 우승자: " + winnerList);
    }

    public static List<String> findWinner(List<Car> cars) {
        List<String> winnerUsers = new ArrayList<>();
        int maxLocation = findMaxLocation(cars);
        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winnerUsers.add(car.getName());
            }
        }
        return winnerUsers;
    }

    private static int findMaxLocation(List<Car> cars) {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(car.getLocation(), maxLocation);
        }
        return maxLocation;
    }
}
