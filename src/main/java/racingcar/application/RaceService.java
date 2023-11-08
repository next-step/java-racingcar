package racingcar.application;

import racingcar.domain.Car;

import java.util.List;
import java.util.Random;

public class RaceService {
    private static final Random random = new Random();

    public static void startRace(List<Car> cars) {
        for (Car car : cars) {
            if (car.isMovable(random.nextInt(10)))
                car.moveForward();
        }
    }
}
