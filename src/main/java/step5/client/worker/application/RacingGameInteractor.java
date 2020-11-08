package step5.client.worker.application;

import common.util.Message;
import step5.client.worker.domain.*;
import step5.client.worker.domain.strategy.RandomMovableStrategy;

import java.util.List;
import java.util.Objects;

import static common.util.Preconditions.checkArgument;
import static step5.client.worker.application.RacingGameInteractor.ErrorMessage.NOT_BE_NULL;

public class RacingGameInteractor {

    public enum ErrorMessage implements Message {
        NOT_BE_NULL(RacingGameInteractor.class.getName() + "'s value should not be null"),
        ;

        private final String message;

        public String getMessage() {
            return message;
        }

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    public RacingGameResponse interact(final RacingGameRequest request) {
        checkArgument(Objects.nonNull(request), NOT_BE_NULL);

        final List<String> carNames = request.getCarNames();
        final int times = request.getNumberAttempts();
        final RacingGame racingGame = RacingGame.of(carNames, new RandomMovableStrategy());

        return getResponseAfterGameFinished(racingGame, times);
    }

    private RacingGameResponse getResponseAfterGameFinished(final RacingGame racingGame, final int times) {
        racingGame.run(times);
        final List<Snapshot> snapshots = racingGame.extractSnapshots();
        final List<String> winners = racingGame.selectWinnerNames();
        return new RacingGameResponse(snapshots, winners);
    }
}