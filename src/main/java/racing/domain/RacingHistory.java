package racing.domain;

import java.util.Set;

public class RacingHistory implements Comparable<RacingHistory>{
    private final Integer round;
    private final Set<Car> raceHistory;

    public RacingHistory(Integer round, Set<Car> raceHistory) {
        this.round = round;
        this.raceHistory = raceHistory;
    }

    public int getRound() {
        return this.round;
    }

    public Set<Car> getRaceHistory() {
        return this.raceHistory;
    }

    @Override
    public int compareTo(RacingHistory o) {
        return this.round.compareTo(o.round);
    }

    public boolean isFirstRound() {
        return this.round == 1;
    }
}
