package step5;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    public static List<Car> getWinners(List<Car> cars) {
        int winnerPos = getWinnerPos(cars);
        return cars.stream()
            .filter(car -> car.getPosition() == winnerPos)
            .collect(Collectors.toList());
    }

    private static int getWinnerPos(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
    }
}
