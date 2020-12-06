package racing.application;

import racing.domain.GameReport;
import racing.domain.Moveable;
import racing.domain.RacingGame;

import java.util.Objects;

public class RacingService {

    private final Moveable moveable;

    public RacingService(final Moveable moveable) {
        this.moveable = Objects.requireNonNull(moveable);
    }


    public GameReport play(final int carCount, final int round) {
        RacingGame racingGame = new RacingGame(moveable);
        return racingGame.play(round, carCount);
    }
}
