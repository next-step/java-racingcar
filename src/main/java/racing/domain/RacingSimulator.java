package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingSimulator {
    private final Racing racing;
    private final Rounds rounds;

    public RacingSimulator(String[] carNames, int attemptsCount) {
        this(new Racing(carNames, attemptsCount), new Rounds());
    }

    public RacingSimulator(Racing racing, Rounds rounds) {
        this.racing = racing;
        this.rounds = rounds;
    }

    public void start() {
        while (racing.hasRun()) {
            racing.runRace();
            rounds.add(racing.currentRound());
        }
    }

    public Rounds getRounds() {
        return rounds;
    }

    public List<Car> getWinnerList() {
        final Round lastRound = rounds.getLast();

        if (lastRound == null) {
            return new ArrayList<>();
        }

        return lastRound.getLeaderList();
    }
}
