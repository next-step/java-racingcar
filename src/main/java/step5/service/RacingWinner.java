package step5.service;

import java.util.List;
import java.util.stream.Collectors;
import step5.domain.Car;

public class RacingWinner {

    public static String chooseWinner(List<Car> cars) {
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
