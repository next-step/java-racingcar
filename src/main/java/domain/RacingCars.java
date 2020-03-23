package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        if (cars == null) {
            throw new IllegalArgumentException("car list is null");
        }
        this.cars = cars;
    }

    public RacingRound moveAll() {
        List<RacingCarPosition> positions = cars.stream()
                .map(RacingCar::move)
                .collect(Collectors.toList());
        return RacingRound.newInstance(positions);
    }
}
