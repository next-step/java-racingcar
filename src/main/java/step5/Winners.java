package step5;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    public static List<Car> getWinners(List<Car> cars) {
        Position winnerPos = getWinnerPos(cars);
        return cars.stream()
            .filter(car -> car.isWinner(winnerPos))
            .collect(Collectors.toList());
    }

    private static Position getWinnerPos(List<Car> cars) {
        return cars.stream()
            .map(Car::getPosition)
            .max(Position::compareTo)
            .get();
    }
}
