package step4;

import java.util.*;
import java.util.stream.Collectors;

public class Winners {
    public List<Car> winners = new ArrayList<>();

    public void getWinners(List<Car> carList) {
        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        winners = carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    public String getWinnerNames() {
        return winners.stream()
                .map(Car -> Car.name)
                .collect(Collectors.joining(","));
    }

}
