package step4;

import java.util.List;
import java.util.stream.Collectors;

public class RacingSupport {

    static void start(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward(isMovable());
        }
    }

    static List<String> chooseWinner(List<Car> cars) {
        int foreFrontLocation = cars.stream()
                .mapToInt(car -> car.getLocation())
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getLocation() == foreFrontLocation)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private static boolean isMovable() {
        RandomGenerator randomGenerator = new RandomGenerator();
        return randomGenerator.isMovable();
    }
}
