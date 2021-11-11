package step3;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGroup {

    private final List<Car> cars;

    public RacingCarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public void carsRun() {
        cars.stream()
                .forEach(c -> c.run());
    }

    public List<Count> carsCurrentPosition() {
        return cars.stream()
                .map(c -> c.currentPosition())
                .collect(Collectors.toList());
    }
}
