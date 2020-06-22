package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public RacingCars whoIsWinners() {
        return new RacingCars(
                this.racingCars
                        .stream()
                        .filter(racingCar -> racingCar.isInPosition(getWinnerPosition()))
                        .collect(Collectors.toList())
        );
    }

    private int getWinnerPosition() {
        return this.racingCars
                .stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
