package racing_winner.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    public static List<Car> getWinners(List<Car> cars) {
        int topLevel = getTopLevel(cars);
        return cars.stream().filter(car -> car.isMatch(topLevel)).collect(Collectors.toUnmodifiableList());
    }

    private static int getTopLevel(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = car.max(max);
        }
        return max;
    }
}
