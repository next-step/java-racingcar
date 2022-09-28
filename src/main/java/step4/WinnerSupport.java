package step4;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerSupport {

    static String chooseWinner(List<Car> cars) {
        int foreFrontLocation = getForeFrontLocation(cars);

        return cars.stream()
                .filter(car -> car.getLocation() == foreFrontLocation)
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
    }

    private static int getForeFrontLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.getLocation())
                .max()
                .getAsInt();
    }
}
