package step4;

import java.util.List;

public class Referee {

    public static Car[] getWinners(List<Car> cars) {
        int winnerPos = getWinnerPos(cars);
        return cars.stream()
            .filter(car -> car.getPosition() == winnerPos)
            .toArray(Car[]::new);
    }

    private static int getWinnerPos(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
    }
}
