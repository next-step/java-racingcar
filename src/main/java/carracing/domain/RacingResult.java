package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return racingCars.stream()
                .filter(racingCar -> racingCar.isGreaterThanPosition(maxPosition))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private Position findMaxPosition() {
        Position maxPosition = new Position();
        for (RacingCar racingCar : racingCars) {
            maxPosition = racingCar.max(maxPosition);
        }
        return maxPosition;
    }
}
