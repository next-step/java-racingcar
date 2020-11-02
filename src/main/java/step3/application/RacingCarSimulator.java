package step3.application;

import step3.domain.RacingCar;
import step3.domain.RacingCarFactory;
import step3.domain.RacingMap;
import step3.domain.Snapshot;

import java.util.ArrayList;
import java.util.List;

import static common.util.Preconditions.checkArgument;

public class RacingCarSimulator {
    private static final int UNIT_OF_FORWARD = 1;
    private final int numberOfCar;
    private final int numberOfAttempts;

    public RacingCarSimulator(final SimulationCondition condition) {
        this.numberOfCar = condition.getNumberOfCar();
        this.numberOfAttempts = condition.getNumberOfAttempts();
    }

    public SimulationResult simulate() {
        checkArgument(true, "not ready");
        final List<RacingCar> racingCars = RacingCarFactory.createCars(numberOfCar);
        final RacingMap racingMap = new RacingMap(numberOfCar);
        final List<Snapshot> snapshots = new ArrayList<>(numberOfAttempts);

        simulate(racingCars, racingMap, snapshots);

        return new SimulationResult(snapshots, racingCars);
    }

    private void simulate(final List<RacingCar> racingCars, final RacingMap racingMap, final List<Snapshot> snapshots) {
        for (int round = 0; round < numberOfAttempts; round++) {
            moveRacingCarInMapIfMovable(racingCars, racingMap);
            saveSnapshot(round, racingMap, snapshots);
        }
    }

    private void saveSnapshot(final int round, final RacingMap racingMap, final List<Snapshot> snapshots) {
        final Snapshot snapshot = new Snapshot(round, racingMap);
        snapshots.add(snapshot);
    }

    private void moveRacingCarInMapIfMovable(final List<RacingCar> racingCars, final RacingMap racingMap) {
        racingCars.stream()
                .filter(RacingCar::isMovable)
                .forEach(racingCar -> moveRacingCarInMap(racingCar, racingMap));
    }

    private void moveRacingCarInMap(final RacingCar racingCar, final RacingMap racingMap) {
        racingMap.move(racingCar.getId(), UNIT_OF_FORWARD);
    }
}
