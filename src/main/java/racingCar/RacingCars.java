package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> cars;

    public RacingCars(final String[] names) {
        this(Arrays.stream(names).map(RacingCar::new).collect(Collectors.toList()));
    }

    public RacingCars(final List<RacingCar> racingCars) {
        this.cars = racingCars;
    }

    public RacingCars racing() {
        RacingCars copied = new RacingCars(cars);

        copied.race();

        return copied;
    }

    private void race() {
        for (RacingCar car : cars) {
            car.tryMove();
        }
    }

    public RacingCar maxPositionCar() {
        RacingCar max = cars.get(0);

        for (RacingCar car : cars) {
            if (car.isFurtherOrEqualThan(max)) {
                max = car;
            }
        }

        return max;
    }

    public List<RacingCar> furtherAsMushAs(RacingCar car) {
        return cars.stream()
                .filter(c -> c.isFurtherAsMuchAs(car))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public String toString() {
        String result = "";
        for (RacingCar car : cars) {
            result += car.toString() + "\n";
        }

        return result;
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }
}
