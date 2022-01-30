package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

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
        return cars.stream()
            .mapToInt(Car::getLocation)
            .max().getAsInt();
    }
}
