package racing.domain;

public class RacingGame {

    private final Moveable moveable;

    public RacingGame(final Moveable moveable) {
        this.moveable = moveable;
    }

    public GameReport play(final int round, final Cars cars) {
        Rounds rounds = Rounds.of(round);
        return rounds.play(cars, moveable);
    }
}
