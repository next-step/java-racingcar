package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getAll() {
        return new ArrayList<>(this.racingCars);
    }

    public List<RacingCar> getWinners() {
        int maxPosition = this.racingCars.stream()
                .map(RacingCar::getPosition)
                .max(Integer::compare)
                .orElse(0);

        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
