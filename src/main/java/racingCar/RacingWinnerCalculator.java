package racingCar;

import java.util.List;
import java.util.Objects;

public class RacingWinnerCalculator {
    private final RacingCars cars;

    public RacingWinnerCalculator(final RacingCars racingCars) {
        this.cars = racingCars;
    }

    public List<RacingCar> winners() {
        final RacingCar maxPositionCar = cars.maxPositionCar();

        return cars.furtherAsMushAs(maxPositionCar);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RacingWinnerCalculator that = (RacingWinnerCalculator) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
