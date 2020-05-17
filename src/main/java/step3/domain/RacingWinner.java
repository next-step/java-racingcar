package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {

    private final List<RacingCar> racingCars;

    public RacingWinner(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<String> getNames() {
        return this.racingCars.stream()
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
