package step4;

import java.util.List;

public class RacingGame {

    static void start(List<Car> cars) {
        for (Car car : cars) {
            if(isMovable()) {
                car.moveForward();
            }
        }
    }

    private static boolean isMovable() {
        RandomNumber random = new RandomNumber();
        return random.isRandomNumberGreaterThanThree();
    }
}
