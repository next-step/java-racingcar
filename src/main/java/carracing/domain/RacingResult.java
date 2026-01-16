package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private final List<RacingCar> racingCars;

    public RacingResult(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> findWinners() {
        return findNameByPosition(findMaxPosition());
    }

    private List<String> findNameByPosition(Position maxPosition) {
        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.isGreaterThanPosition(maxPosition)) {
                winners.add(racingCar.getName());
            }
        }
        return winners;
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.isGreaterThanPosition(maxPosition)) {
                maxPosition = racingCar.getPosition();
            }
        }
        return maxPosition;
    }
}
