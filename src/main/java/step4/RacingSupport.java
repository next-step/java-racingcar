package step4;

import java.util.List;

public class RacingSupport {

    static void start(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward(isMovable());
        }
    }

    private static boolean isMovable() {
        RandomGenerator randomGenerator = new RandomGenerator();
        return randomGenerator.isRandomGreaterThanThree();
    }
}
