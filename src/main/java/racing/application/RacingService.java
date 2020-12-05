package racing.application;

import racing.domain.GameReport;
import racing.domain.RacingGame;

import java.util.Objects;

public class RacingService {

    private final RacingGame racingGame;

    public RacingService(final RacingGame racingGame) {
        this.racingGame = Objects.requireNonNull(racingGame);
    }


    public GameReport play(final int carCount, final int round) {
        return racingGame.play(round, carCount);
    }
}
