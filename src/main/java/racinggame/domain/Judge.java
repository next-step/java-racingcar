package racinggame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    private Judge() {}

    public static List<String> getWinners(final RacingCars racingCars) {
        final int maximumPosition = getHighScore(racingCars);

        return racingCars.get().stream()
                .filter(car -> car.isMatchPosition(maximumPosition))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private static int getHighScore(final RacingCars racingCars) {
        return Collections.max(getCarPositions(racingCars));
    }

    private static List<Integer> getCarPositions(final RacingCars racingCars) {
        return racingCars.get().stream()
                .map(RacingCar::getPosition)
                .collect(Collectors.toList());
    }
}
