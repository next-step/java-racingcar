package racing_game.domain;

import racing_game.core.Positive;
import racing_game.core.SnapShot;

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
            snapShot.capture(cars.getDistances());
        }
        return snapShot;
    }

    public Cars getCars() {
        return cars;
    }

    public Positive getTryCount() {
        return tryCount;
    }
}
