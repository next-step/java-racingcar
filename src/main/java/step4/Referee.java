package step4;

import java.util.Arrays;

public class Referee {

    public static Car[] getWinners(Car[] cars) {
        int winnerPos = getWinnerPos(cars);
        return Arrays.stream(cars)
            .filter(car -> car.getPosition() == winnerPos)
            .toArray(Car[]::new);
    }

    private static int getWinnerPos(Car[] cars) {
        return Arrays.stream(cars)
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
    }
}
