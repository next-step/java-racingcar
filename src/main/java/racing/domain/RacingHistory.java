package racing.domain;

import java.util.Set;

public class RacingHistory implements Comparable<RacingHistory>{
    private final Integer round;
    private final Set<Car> HistorySet;

    public RacingHistory(Integer round, Set<Car> HistorySet) {
        this.round = round;
        this.HistorySet = HistorySet;
    }

    public int getRound() {
        return this.round;
    }

    public Set<Car> getHistorySet() {
        return this.HistorySet;
    }

    @Override
    public int compareTo(RacingHistory o) {
        return this.round.compareTo(o.round);
    }
}
