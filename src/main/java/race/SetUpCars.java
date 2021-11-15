package race;

import race.domain.Car;
import race.domain.CarName;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

class SetUpCars {
    private final Collection<CarName> carNames;

    public SetUpCars(Collection<CarName> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("numberOfCarNames must be positive");
        }
        this.carNames = carNames;
    }

    Collection<Car> setUp() {
        return Collections.unmodifiableCollection(
                carNames.stream().map(Car::new).collect(Collectors.toList())
        );
    }
}
