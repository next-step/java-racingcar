package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingPosition {

    private final List<RacingCar> racingCars;

    public RacingPosition(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<String> getPositions() {
        return this.racingCars.stream()
                .map(RacingCar::toString)
                .collect(Collectors.toList());
    }
}
