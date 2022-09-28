package step4;

import java.util.List;

public class RacingStarter {

    static List<Car> start(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward(isMovable());
        }

        return cars;
    }

    private static boolean isMovable() {
        RandomGenerator randomGenerator = new RandomGenerator();
        return randomGenerator.isMovable();
    }
}
