package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Moveable moveable;

    public RacingGame(final Moveable moveable) {
        this.moveable = moveable;
    }

    public GameReport play(final int round, final Cars cars) {
        List<RoundReport> roundReports = new ArrayList<>(round);
        Cars racingCars = cars;
        for (int i = 0; i < round; i++) {
            racingCars = racingCars.forward(moveable);
            roundReports.add(racingCars.report());
        }
        return new GameReport(roundReports);
    }
}
