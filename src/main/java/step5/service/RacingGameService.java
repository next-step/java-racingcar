package step5.service;

import java.util.ArrayList;
import java.util.List;
import step5.domain.Car;
import step5.domain.RacingResult;
import step5.domain.RandomNumber;

public class RacingGameService {

    private static final int MOVABLE_BOUNDARY = 3;

    public static List<RacingResult> start(List<Car> cars) {
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
