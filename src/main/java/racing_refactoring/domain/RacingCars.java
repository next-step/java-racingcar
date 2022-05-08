package racing_refactoring.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars findWinners(RacingCars racingCars) {
        return findWinners(racingCars, maxPosition(racingCars));
    }

    private static RacingCars findWinners(RacingCars racingCars, int maxPosition) {
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            if (racingCar.isWinner(maxPosition)) {
                winners.add(racingCar);
            }
        }
        return new RacingCars(winners);
    }

    private static int maxPosition(RacingCars racingCars) {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            maxPosition = racingCar.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
