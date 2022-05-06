package racing_refactoring.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingWinners {

    private final List<RacingCar> winners;

    private RacingWinners(List<RacingCar> winners) {
        this.winners = winners;
    }

    public static RacingWinners findWinners(RacingCars racingCars) {
        return findWinners(racingCars, maxPosition(racingCars));
    }

    private static RacingWinners findWinners(RacingCars racingCars, int maxPosition) {
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            if (racingCar.isWinner(maxPosition)) {
                winners.add(racingCar);
            }
        }
        return new RacingWinners(winners);
    }

    private static int maxPosition(RacingCars racingCars) {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            maxPosition = racingCar.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<RacingCar> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
