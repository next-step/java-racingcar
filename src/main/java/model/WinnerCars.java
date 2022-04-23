package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerCars {

    private WinnerCars() {

    }

    public static List<Car> getWinnerCars(List<Car> cars) {
        int winnerPosition = getWinnerPosition(cars);
        return cars.stream()
                .filter(x -> x.getPosition().getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    private static Integer getWinnerPosition(List<Car> cars) {
        List<Integer> positions = cars.stream()
                .map(x -> x.getPosition().getPosition())
                .collect(Collectors.toList());

        return Collections.max(positions);
    }


}
