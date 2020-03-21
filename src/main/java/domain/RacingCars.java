package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public RacingRound moveAll() {
        List<Integer> positions = cars.stream()
                .map(car -> car.move())
                .collect(Collectors.toList());
        return new RacingRound(positions);
    }
}
