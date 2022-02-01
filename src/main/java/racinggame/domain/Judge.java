package racinggame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    private Judge() {}

    public static List<String> getWinners(RacingCars racingCars) {
        int maximumPosition = getHighScore(racingCars);

        return racingCars.getRacingCars().stream()
                .filter(car -> car.isMatchePosition(maximumPosition))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private static int getHighScore(RacingCars racingCars) {
        return Collections.max(getCarPositions(racingCars));
    }

    private static List<Integer> getCarPositions(RacingCars racingCars) {
        return racingCars.getRacingCars().stream()
                .map(RacingCar::getPosition)
                .collect(Collectors.toList());
    }
}
