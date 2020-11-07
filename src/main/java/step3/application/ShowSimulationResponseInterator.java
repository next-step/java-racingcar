package step3.application;

import common.util.Message;
import step3.domain.*;
import step3.domain.strategy.RandomMovableStrategy;

import java.util.List;
import java.util.Objects;

import static common.util.Preconditions.checkArgument;
import static step3.application.ShowSimulationResponseInterator.ErrorMessage.NOT_BE_NULL;

public class ShowSimulationResponseInterator {
    private final List<String> carNames;
    private final int numberAttempts;

    public enum ErrorMessage implements Message {
        NOT_BE_NULL(ShowSimulationResponseInterator.class.getName() + "'s value should not be null"),
        ;

        private final String message;

        public String getMessage() {
            return message;
        }

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    public ShowSimulationResponseInterator(final SimulationRequest condition) {
        checkArgument(Objects.nonNull(condition), NOT_BE_NULL);
        this.carNames = condition.getCarNames();
        this.numberAttempts = condition.getNumberAttempts();
    }

    public SimulationResponse interact() {
        final RacingGame racingGame = RacingGame.of(carNames, new RandomMovableStrategy());
        final List<Snapshot> snapshots = racingGame.run(numberAttempts);
        final List<String> winners = racingGame.selectWinnerNames();

        return new SimulationResponse(snapshots, winners);
    }
}