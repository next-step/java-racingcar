package racingcar.domain;

import java.util.List;

public class Winners {
    public static List<RacingCar> findWinners(RacingCars racingCars) {
        return findWinners(racingCars, racingCars.maxPosition());
    }

    private static List<RacingCar> findWinners(RacingCars racingCars, int maxPosition) {
        return racingCars.maxPositionCar(maxPosition);
    }
}
