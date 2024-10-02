package racingGame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {
    private final List<RacingCar> racingCars;

    public RoundResult(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return List.copyOf(racingCars);
    }

    public List<String> getWinners() {
        int maxPosition = racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
