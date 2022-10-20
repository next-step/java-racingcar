package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingWinnerCalculator {
    private final RacingCar[] cars;

    public RacingWinnerCalculator(final RacingCar[] racingCars) {
        this.cars = racingCars;
    }

    public List<RacingCar> winners() {
        final int maxMovement = Arrays.stream(cars)
                .mapToInt(RacingCar::getNumberOfMovement)
                .max()
                .orElse(0);

        return Arrays.stream(cars)
                .filter(c -> c.isFurtherAsMuchAs(maxMovement))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RacingWinnerCalculator that = (RacingWinnerCalculator) o;
        return Arrays.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cars);
    }
}
