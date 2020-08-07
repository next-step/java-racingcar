package step5.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CheckerFlag {
    public static String showFinalChampion(List<Car> cars, int finalChampion) {
        return cars.stream()
                   .filter(car ->
                               finalChampion == car.getLocation())
                   .map(Car::getDriverName)
                   .collect(Collectors.joining(","));
    }
}
