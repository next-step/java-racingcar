package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars(RacingCars racingCars) {
        this.racingCars = racingCars.getRacingCars()
                                    .stream()
                                    .map(RacingCar::new)
                                    .collect(Collectors.toUnmodifiableList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public int getMaxDistance() {
        int maxDistance = Integer.MIN_VALUE;

        for (RacingCar racingCar : this.racingCars) {
            maxDistance = Math.max(maxDistance, racingCar.getDistance());
        }

        return maxDistance;
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
