package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public static List<String> getWinners(Cars cars) {
        int maxMovingDistance = cars.getMaxMovingDistance();

        return cars.getCars().stream()
            .filter(car -> car.isWinner(maxMovingDistance)).map(Car::getName)
            .collect(Collectors.toList());
    }
}
