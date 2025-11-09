package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {
    private final List<RoundResult> rounds;

    public RaceHistory() {
        this.rounds = new ArrayList<>();
    }

    public void record(RoundResult roundResult) {
        this.rounds.add(roundResult);
    }

    public int size() {
        return this.rounds.size();
    }

    public RoundResult getRound(int index) {
        return this.rounds.get(index);
    }
}
