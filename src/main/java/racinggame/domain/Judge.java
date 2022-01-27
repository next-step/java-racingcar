package racinggame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    private Judge() {}

    public static List<String> getWinners(List<RacingCar> racingCars) {
        int maximumPosition = getHighScore(racingCars);

        return racingCars.stream()
                .filter(car -> car.getPosition() == maximumPosition)
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }

    private static int getHighScore(List<RacingCar> racingCars) {
        return Collections.max(getCarPositions(racingCars));
    }

    private static List<Integer> getCarPositions(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList());
    }
}
