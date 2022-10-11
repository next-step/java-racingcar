package step5.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    public static List<Car> getWinner(List<Car> carList) {

        int max = carList.stream().mapToInt(it -> it.location).max().getAsInt();
        List<Car> winners = carList.stream().filter(it -> isWinner(it, max)).collect(Collectors.toList());
        return winners;
    }

    private static boolean isWinner(Car car, int max) {
        if (max == car.location) {
            return true;
        }
        return false;
    }
}
