package racing.domain;

import racing.exception.RoundOutOfRangeException;

import java.util.ArrayList;
import java.util.List;

public class Rounds {

    public static final int MIN_VALUE = 1;

    private final int round;

    public Rounds(final int round) {
        this.round = round;
    }

    public static Rounds of(final int value) {
        if (value < MIN_VALUE) {
            throw new RoundOutOfRangeException(value);
        }

        return new Rounds(value);
    }

    public GameReport play(final Cars cars, final Moveable moveable) {
        List<RoundReport> roundReports = new ArrayList<>(round);
        Cars racingCars = cars;
        for (int i = 0; i < round; i++) {
            racingCars = racingCars.forward(moveable);
            roundReports.add(racingCars.report());
        }
        return new GameReport(roundReports);
    }
}
