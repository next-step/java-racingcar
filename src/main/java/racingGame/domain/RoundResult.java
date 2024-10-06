package racingGame.domain;

import racingGame.domain.car.RacingCar;

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
        int maxPositionValue = racingCars.stream()
                .mapToInt(RacingCar::getPositionValue)
                .max()
                .orElse(0);


        return racingCars.stream()
                .filter(car -> car.getPositionValue() == (maxPositionValue))
                .map(RacingCar::getNameValue)
                .collect(Collectors.toList());
    }
}
