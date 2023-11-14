package step4;

import java.util.*;
import java.util.stream.Collectors;

public class Winner {
    public static List<Car> winners = new ArrayList<>();

    public void getWinners(List<Car> carList) {

        for (Car car : carList) {
            this.addWinners(car);
        }
    }

    public void addWinners(Car car) {
        if (winners.isEmpty()) {
            winners.add(car);
            return;
        }

        if (winners.get(0).getDistance() == car.getDistance()) {
            winners.add(car);
            return;
        }

        if (winners.get(0).getDistance() < car.getDistance()) {
            winners.clear();
            winners.add(car);
        }
    }

    public static String getWinnerNames() {
        return winners.stream()
                .map(Car -> Car.name)
                .collect(Collectors.joining(","));
    }

}
