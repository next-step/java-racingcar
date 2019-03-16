package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public List<RacingCar> get() {
        return new ArrayList<>(racingCars);
    }

    public RacingCars race(final MovingStrategy movingStrategy) {
        return new RacingCars(
                this.racingCars
                        .stream()
                        .map(racingCar -> racingCar.move(movingStrategy))
                        .collect(Collectors.toList())
        );
    }

    public RacingCars whoWentTheFarthest() {
        return new RacingCars(
                this.racingCars
                        .stream()
                        .filter(racingCar -> racingCar.isInPosition(getFarthestPosition()))
                        .collect(Collectors.toList())
        );
    }

    private int getFarthestPosition() {
        return this.racingCars
                .stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0)
                ;
    }
}
