package racing_game.controller;

import java.util.List;
import java.util.stream.Collectors;
import racing_game.core.Positive;
import racing_game.core.SnapShot;
import racing_game.domain.Car;
import racing_game.domain.Cars;
import racing_game.domain.Distances;
import racing_game.domain.SimulationConfig;

public class Simulator {

    private final Cars cars;
    private final Positive tryCount;
    private final SnapShot<Distances> snapShot;

    private Simulator(Positive carCount, Positive tryCount) {
        this.cars = Cars.create(carCount);
        this.tryCount = tryCount;
        this.snapShot = new SnapShot<>();
    }

    public static Simulator create(SimulationConfig simulationConfig) {
        return new Simulator(simulationConfig.getCarCount(), simulationConfig.getTryCount());
    }

    public SnapShot<Distances> simulate() {
        for (int i = 0; i < tryCount.toInt(); i++) {
            cars.moveAll();
            snapShot.capture(getDistances(cars));
        }
        return snapShot;
    }

    public Cars getCars() {
        return cars;
    }

    public Positive getTryCount() {
        return tryCount;
    }

    private Distances getDistances(Cars cars) {
        List<Positive> distances = cars.toList()
            .stream()
            .map(Car::getDistance)
            .collect(Collectors.toUnmodifiableList());

        return Distances.create(distances);
    }
}
