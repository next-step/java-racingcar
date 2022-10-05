package step5;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int MOVABLE_BOUNDARY = 3;

    static List<RacingResult> start(List<Car> cars) {
        List<RacingResult> racingResults = new ArrayList<>();
        for (Car car : cars) {
            moveCar(car, isMovable());
        }

        return racingResults;
    }

    private static void moveCar(Car car, boolean isMovable) {
        if (isMovable) {
            car.moveForward();
        }
    }

    private static boolean isMovable() {
        int randomNumber = RandomNumber.getRandomNumber();
        return randomNumber > MOVABLE_BOUNDARY;
    }
}
