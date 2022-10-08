package racinggame.model;

import racinggame.domain.CarName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGameResult {

    private final List<RacingGameRoundResult> rounds;

    public RacingGameResult() {
        this.rounds = new ArrayList<>();
    }

    public RacingGameResult(List<RacingGameRoundResult> rounds) {
        this.rounds = rounds;
    }

    public void add(RacingGameRoundResult round) {
        rounds.add(round);
    }

    public List<CarName> getWinnerNames() {
        RacingGameRoundResult lastRound = rounds.get(rounds.size() - 1);
        return lastRound.getFarthestCarNames();
    }

    public List<RacingGameRoundResult> getRounds() {
        return rounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGameResult that = (RacingGameResult) o;
        return Objects.equals(rounds, that.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rounds);
    }

}
