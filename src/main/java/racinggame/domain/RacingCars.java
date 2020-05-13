package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(int numberOfCar) {
        this.cars = createInitIalCar(numberOfCar);
    }

    public RacingGameSnapshot race(Engine engine) {
        RacingGameSnapshot snapshot = new RacingGameSnapshot();

        for (Car racingCar : cars) {
            int currentPosition = racingCar.move(engine);
            snapshot.record(new CarSnapshot(currentPosition));
        }

        return snapshot;
    }

    private List<Car> createInitIalCar(int numberOfCar) {
        List<Car> initialCars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            initialCars.add(new Car());
        }

        return initialCars;
    }
}
