package step4;

import java.util.List;
import java.util.Random;

public class RacingGame {

    static void start(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward(randomNumber());
        }
    }

    private static int randomNumber() {
        return new Random().nextInt(10);
    }
}
