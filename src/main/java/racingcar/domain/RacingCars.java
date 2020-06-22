package racingcar.domain;

import racingcar.utils.Const;

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

    public List<String> getNames() {
        return racingCars
                .stream()
                .map(racingCar -> racingCar.getCarName())
                .collect(Collectors.toList());
    }

    public List<RacingCar> get() {
        return racingCars;
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

    @Override
    public String toString() {
        List<String> names =
                racingCars
                .stream()
                .map(racingCar -> racingCar.getCarName())
                .collect(Collectors.toList());

        return String.join(Const.SYMBOL_COMMA, names);
    }
}
