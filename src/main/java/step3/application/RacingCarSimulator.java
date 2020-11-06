package step3.application;

import common.util.Message;
import step3.domain.*;

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
        final RacingMap racingMap = RacingMap.of(racingCars);
        final List<Snapshot> snapshots = createSimulationSnapshots(racingMap, numberOfAttempts);

        return new SimulationResult(snapshots);
    }

    private List<Snapshot> createSimulationSnapshots(final RacingMap racingMap, final int numberOfAttempts) {
        final List<Snapshot> snapshots = new ArrayList<>(numberOfAttempts);
        for (int i = 0; i < numberOfAttempts; i++) {
            racingMap.moveRacingCars(UNIT_OF_FORWARD);
            final Snapshot snapshot = racingMap.createSnapshot();
            snapshots.add(snapshot);
        }
        return snapshots;
    }
}