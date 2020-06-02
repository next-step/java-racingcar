package racing.domain;

import racing.util.ListCopier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final List<Integer> carLocations;
    private final int numberOfRound;

    private final RacingResult racingResult = new RacingResult();

    public RacingGame(int numberOfCar, int numberOfRound) {
        this.carLocations = new ArrayList<>(Collections.nCopies(numberOfCar, 0));
        this.numberOfRound = numberOfRound;
    }

    public RacingResult play(final MoveStrategy moveStrategy) {
        for (int i = 0; i < numberOfRound; i++) {
            racingResult.put(i, getRoundResultBy(moveStrategy));
        }
        return racingResult;
    }

    private List<Integer> getRoundResultBy(final MoveStrategy moveStrategy) {
        for (int i = 0; i < carLocations.size(); i++) {
            final int currentLocation = carLocations.get(i) + getMoveDistance(moveStrategy.isMovable());
            carLocations.set(i, currentLocation);
        }
        return ListCopier.copyList(carLocations);
    }

    private int getMoveDistance(boolean isMovable) {
        return isMovable ? 1 : 0;
    }
}
