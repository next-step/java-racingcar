package racingcar.model;

import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public List<RacingCar> findWinner(List<RacingCar> cars) {
        int maxPosition = maxPosition(cars);
        return winners(cars, maxPosition);
    }

    private int maxPosition(List<RacingCar> cars) {
        int maxPosition = 0;
        for (RacingCar car : cars) {
            maxPosition = car.position().biggerPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<RacingCar> winners(List<RacingCar> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.position().matchPosition(maxPosition))
                .collect(Collectors.toList());
    }
}
