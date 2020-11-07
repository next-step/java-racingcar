package step3.application;

import common.util.Message;
import step3.domain.*;
import step3.domain.strategy.RandomMovableStrategy;

import java.util.List;
import java.util.Objects;

import static common.util.Preconditions.checkArgument;
import static step3.application.RacingCarSimulator.ErrorMessage.NOT_BE_NULL;

public class RacingCarSimulator {
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
        final RacingGame racingGame = RacingGame.of(carNames, new RandomMovableStrategy());
        final List<Snapshot> snapshots = racingGame.run(numberOfAttempts);
        final List<String> winners = racingGame.selectWinnerNames();

        return new SimulationResult(snapshots, winners);
    }
}