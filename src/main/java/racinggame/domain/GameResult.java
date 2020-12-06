package racinggame.domain;

import racinggame.domain.car.CarName;
import racinggame.domain.car.RacingCar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<RacingCar> racingCars;

    public GameResult(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<CarName> pickWinners() {
        int maxPosition = selectMaxPosition();
        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int selectMaxPosition() {
        return racingCars.stream()
                .max(Comparator.comparingInt(RacingCar::getPosition))
                .get()
                .getPosition();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
