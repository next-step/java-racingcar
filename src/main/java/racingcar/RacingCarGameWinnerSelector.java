package racingcar;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingCarGameWinnerSelector {

    public static List<RacingCar> getWinnerRacingCars(List<RacingCar> racingCars) {
        int maxPosition = getMaxPosition(racingCars);
        return racingCars.stream()
            .filter(racingCar -> racingCar.isEqualsPosition(maxPosition))
            .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<RacingCar> racingCars) {
        return racingCars.stream()
            .mapToInt(RacingCar::getPosition)
            .max()
            .orElseThrow(NoSuchElementException::new);
    }
}
