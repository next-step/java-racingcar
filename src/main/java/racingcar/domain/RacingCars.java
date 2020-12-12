package racingcar.domain;

import racingcar.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        if (racingCars != null) {
            this.racingCars = racingCars;
            return;
        }
        this.racingCars = new ArrayList<RacingCar>();
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
        return "RacingCars{" +
                "racingCars=" + racingCars +
                '}';
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
