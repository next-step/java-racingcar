package step3.application;

import common.util.Message;
import step3.domain.RacingCar;
import step3.domain.RacingCarFactory;
import step3.domain.RacingMap;
import step3.domain.Snapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static common.util.Preconditions.checkArgument;
import static step3.application.RacingCarSimulator.ErrorMessage.NOT_BE_NULL;

public class RacingCarSimulator {
    private static final int UNIT_OF_FORWARD = 1;
    private final List<String> carNames;
    private final int numberOfAttempts;

    public enum ErrorMessage implements Message {
        NOT_BE_NULL(RacingCarSimulator.class.getName() + "'s value should not be null"),
        ;

        private final String message;

        public String getMessage() {
            return message;
        }

        ErrorMessage(String message) {
            this.message = message;
        }
    }
    
    public RacingCarSimulator(final SimulationCondition condition) {
        checkArgument(Objects.nonNull(condition), NOT_BE_NULL);
        this.carNames = condition.getCarNames();
        this.numberOfAttempts = condition.getNumberOfAttempts();
    }

    public SimulationResult simulate() {
        final List<RacingCar> racingCars = RacingCarFactory.createCars(carNames, new RandomMovableStrategy());
        final RacingMap racingMap = new RacingMap(racingCars);
        final List<Snapshot> snapshots = new ArrayList<>(numberOfAttempts);

        simulate(racingCars, racingMap, snapshots);

        return new SimulationResult(snapshots, racingCars, racingMap.selectWinnerNames());
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
        racingMap.move(racingCar, UNIT_OF_FORWARD);
    }
}
